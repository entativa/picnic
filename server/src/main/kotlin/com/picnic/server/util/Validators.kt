package com.picnic.server.util

import org.mindrot.jbcrypt.BCrypt

/**
 * Password hashing and validation utilities
 */
object PasswordHasher {
    
    private const val LOG_ROUNDS = 12
    
    /**
     * Hash a password using BCrypt
     */
    fun hashPassword(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt(LOG_ROUNDS))
    }
    
    /**
     * Verify a password against a hash
     */
    fun verifyPassword(password: String, hash: String): Boolean {
        return try {
            BCrypt.checkpw(password, hash)
        } catch (e: Exception) {
            false
        }
    }
    
    /**
     * Validate password strength
     * Returns error message if invalid, null if valid
     */
    fun validatePasswordStrength(password: String): String? {
        return when {
            password.length < 8 -> "Password must be at least 8 characters long"
            !password.any { it.isUpperCase() } -> "Password must contain at least one uppercase letter"
            !password.any { it.isLowerCase() } -> "Password must contain at least one lowercase letter"
            !password.any { it.isDigit() } -> "Password must contain at least one number"
            else -> null
        }
    }
}

/**
 * Email validation
 */
object EmailValidator {
    private val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
    
    fun isValid(email: String): Boolean {
        return email.matches(emailRegex)
    }
}

/**
 * Username validation
 */
object UsernameValidator {
    private val usernameRegex = "^[a-zA-Z0-9_]{3,30}$".toRegex()
    
    fun isValid(username: String): Boolean {
        return username.matches(usernameRegex)
    }
    
    fun getValidationError(username: String): String? {
        return when {
            username.length < 3 -> "Username must be at least 3 characters long"
            username.length > 30 -> "Username must be at most 30 characters long"
            !username.matches(usernameRegex) -> "Username can only contain letters, numbers, and underscores"
            else -> null
        }
    }
}
