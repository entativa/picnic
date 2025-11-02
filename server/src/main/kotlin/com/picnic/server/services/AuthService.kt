package com.picnic.server.services

import com.picnic.server.data.database.*
import com.picnic.server.util.JwtConfig
import com.picnic.server.util.PasswordHasher
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime
import java.util.*

@Serializable
data class UserDto(
    val id: String,
    val email: String,
    val username: String,
    val displayName: String,
    val bio: String? = null,
    val avatarUrl: String? = null,
    val headerImageUrl: String? = null,
    val location: String? = null,
    val website: String? = null,
    val isVerified: Boolean = false,
    val isPrivate: Boolean = false,
    val followerCount: Int = 0,
    val followingCount: Int = 0,
    val postCount: Int = 0,
    val likeCount: Int = 0,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class RegisterRequest(
    val email: String,
    val password: String,
    val username: String,
    val displayName: String
)

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)

@Serializable
data class AuthResponse(
    val accessToken: String,
    val refreshToken: String,
    val user: UserDto
)

@Serializable
data class RefreshTokenRequest(
    val refreshToken: String
)

/**
 * Authentication service handling user registration, login, and token management
 */
class AuthService(private val jwtConfig: JwtConfig) {
    
    /**
     * Register a new user
     */
    suspend fun register(request: RegisterRequest): Result<AuthResponse> = dbQuery {
        // Check if email already exists
        val existingEmail = Users.select { Users.email eq request.email }.singleOrNull()
        if (existingEmail != null) {
            return@dbQuery Result.failure(Exception("Email already registered"))
        }
        
        // Check if username already exists
        val existingUsername = Users.select { Users.username eq request.username }.singleOrNull()
        if (existingUsername != null) {
            return@dbQuery Result.failure(Exception("Username already taken"))
        }
        
        // Hash password
        val passwordHash = PasswordHasher.hashPassword(request.password)
        
        // Create user
        val userId = Users.insertAndGetId {
            it[email] = request.email
            it[username] = request.username
            it[this.passwordHash] = passwordHash
            it[displayName] = request.displayName
        }.value.toString()
        
        // Generate tokens
        val accessToken = jwtConfig.generateAccessToken(userId, request.email)
        val refreshToken = jwtConfig.generateRefreshToken(userId)
        
        // Store refresh token
        saveRefreshToken(UUID.fromString(userId), refreshToken)
        
        // Get user data
        val user = getUserById(userId) ?: return@dbQuery Result.failure(Exception("User creation failed"))
        
        Result.success(AuthResponse(accessToken, refreshToken, user))
    }
    
    /**
     * Login existing user
     */
    suspend fun login(request: LoginRequest): Result<AuthResponse> = dbQuery {
        // Find user by email
        val userRow = Users.select { Users.email eq request.email }.singleOrNull()
            ?: return@dbQuery Result.failure(Exception("Invalid email or password"))
        
        // Verify password
        val passwordHash = userRow[Users.passwordHash]
        if (!PasswordHasher.verifyPassword(request.password, passwordHash)) {
            return@dbQuery Result.failure(Exception("Invalid email or password"))
        }
        
        val userId = userRow[Users.id].value.toString()
        
        // Update last login
        Users.update({ Users.id eq userRow[Users.id] }) {
            it[lastLoginAt] = LocalDateTime.now()
        }
        
        // Generate tokens
        val accessToken = jwtConfig.generateAccessToken(userId, request.email)
        val refreshToken = jwtConfig.generateRefreshToken(userId)
        
        // Store refresh token
        saveRefreshToken(userRow[Users.id].value, refreshToken)
        
        // Get user data
        val user = getUserById(userId) ?: return@dbQuery Result.failure(Exception("User not found"))
        
        Result.success(AuthResponse(accessToken, refreshToken, user))
    }
    
    /**
     * Refresh access token using refresh token
     */
    suspend fun refreshToken(request: RefreshTokenRequest): Result<AuthResponse> = dbQuery {
        // Validate refresh token
        if (!jwtConfig.validateToken(request.refreshToken)) {
            return@dbQuery Result.failure(Exception("Invalid refresh token"))
        }
        
        if (jwtConfig.getTokenType(request.refreshToken) != "refresh") {
            return@dbQuery Result.failure(Exception("Invalid token type"))
        }
        
        // Check if token exists and is not revoked
        val tokenRow = RefreshTokens.select { 
            RefreshTokens.token eq request.refreshToken 
        }.singleOrNull() ?: return@dbQuery Result.failure(Exception("Refresh token not found"))
        
        if (tokenRow[RefreshTokens.isRevoked]) {
            return@dbQuery Result.failure(Exception("Refresh token has been revoked"))
        }
        
        if (tokenRow[RefreshTokens.expiresAt].isBefore(LocalDateTime.now())) {
            return@dbQuery Result.failure(Exception("Refresh token has expired"))
        }
        
        val userId = tokenRow[RefreshTokens.userId].value.toString()
        
        // Get user
        val userRow = Users.select { Users.id eq tokenRow[RefreshTokens.userId] }.singleOrNull()
            ?: return@dbQuery Result.failure(Exception("User not found"))
        
        // Generate new tokens
        val newAccessToken = jwtConfig.generateAccessToken(userId, userRow[Users.email])
        val newRefreshToken = jwtConfig.generateRefreshToken(userId)
        
        // Revoke old refresh token
        RefreshTokens.update({ RefreshTokens.token eq request.refreshToken }) {
            it[isRevoked] = true
        }
        
        // Store new refresh token
        saveRefreshToken(userRow[Users.id].value, newRefreshToken)
        
        // Get user data
        val user = getUserById(userId) ?: return@dbQuery Result.failure(Exception("User not found"))
        
        Result.success(AuthResponse(newAccessToken, newRefreshToken, user))
    }
    
    /**
     * Logout user (revoke refresh token)
     */
    suspend fun logout(refreshToken: String): Result<Unit> = dbQuery {
        RefreshTokens.update({ RefreshTokens.token eq refreshToken }) {
            it[isRevoked] = true
        }
        Result.success(Unit)
    }
    
    /**
     * Get user by ID
     */
    suspend fun getUserById(userId: String): UserDto? = dbQuery {
        Users.select { Users.id eq UUID.fromString(userId) }
            .singleOrNull()
            ?.toUserDto()
    }
    
    private fun saveRefreshToken(userId: UUID, token: String) {
        RefreshTokens.insert {
            it[RefreshTokens.userId] = userId
            it[RefreshTokens.token] = token
            it[expiresAt] = LocalDateTime.now().plusDays(30)
        }
    }
    
    private fun ResultRow.toUserDto() = UserDto(
        id = this[Users.id].value.toString(),
        email = this[Users.email],
        username = this[Users.username],
        displayName = this[Users.displayName],
        bio = this[Users.bio],
        avatarUrl = this[Users.avatarUrl],
        headerImageUrl = this[Users.headerImageUrl],
        location = this[Users.location],
        website = this[Users.website],
        isVerified = this[Users.isVerified],
        isPrivate = this[Users.isPrivate],
        followerCount = this[Users.followerCount],
        followingCount = this[Users.followingCount],
        postCount = this[Users.postCount],
        likeCount = this[Users.likeCount],
        createdAt = this[Users.createdAt].toString(),
        updatedAt = this[Users.updatedAt].toString()
    )
}

/**
 * Database query wrapper
 */
suspend fun <T> dbQuery(block: () -> T): T = transaction { block() }
