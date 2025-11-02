package com.picnic.server.util

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

/**
 * JWT token generation and validation
 */
class JwtConfig(
    private val secret: String,
    private val issuer: String,
    private val audience: String,
    val realm: String,
    private val accessTokenExpiration: Long,
    private val refreshTokenExpiration: Long
) {
    private val algorithm = Algorithm.HMAC256(secret)
    
    val verifier: JWTVerifier = JWT
        .require(algorithm)
        .withIssuer(issuer)
        .withAudience(audience)
        .build()
    
    /**
     * Generate access token for user
     */
    fun generateAccessToken(userId: String, email: String): String {
        return JWT.create()
            .withIssuer(issuer)
            .withAudience(audience)
            .withSubject(userId)
            .withClaim("email", email)
            .withClaim("type", "access")
            .withExpiresAt(Date(System.currentTimeMillis() + accessTokenExpiration))
            .withIssuedAt(Date())
            .sign(algorithm)
    }
    
    /**
     * Generate refresh token for user
     */
    fun generateRefreshToken(userId: String): String {
        return JWT.create()
            .withIssuer(issuer)
            .withAudience(audience)
            .withSubject(userId)
            .withClaim("type", "refresh")
            .withExpiresAt(Date(System.currentTimeMillis() + refreshTokenExpiration))
            .withIssuedAt(Date())
            .sign(algorithm)
    }
    
    /**
     * Extract user ID from token
     */
    fun getUserId(token: String): String? {
        return try {
            verifier.verify(token).subject
        } catch (e: Exception) {
            null
        }
    }
    
    /**
     * Validate token
     */
    fun validateToken(token: String): Boolean {
        return try {
            verifier.verify(token)
            true
        } catch (e: Exception) {
            false
        }
    }
    
    /**
     * Get token type (access or refresh)
     */
    fun getTokenType(token: String): String? {
        return try {
            verifier.verify(token).getClaim("type").asString()
        } catch (e: Exception) {
            null
        }
    }
    
    /**
     * Check if token is expired
     */
    fun isTokenExpired(token: String): Boolean {
        return try {
            val expiresAt = verifier.verify(token).expiresAt
            expiresAt.before(Date())
        } catch (e: Exception) {
            true
        }
    }
}
