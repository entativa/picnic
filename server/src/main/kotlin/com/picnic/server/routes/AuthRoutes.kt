package com.picnic.server.routes

import com.picnic.server.services.*
import com.picnic.server.util.EmailValidator
import com.picnic.server.util.PasswordHasher
import com.picnic.server.util.UsernameValidator
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val code: String,
    val message: String,
    val details: Map<String, String>? = null
)

/**
 * Authentication routes
 */
fun Route.authRoutes(authService: AuthService) {
    
    route("/auth") {
        
        /**
         * POST /api/auth/register
         * Register a new user
         */
        post("/register") {
            try {
                val request = call.receive<RegisterRequest>()
                
                // Validate email
                if (!EmailValidator.isValid(request.email)) {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        ErrorResponse("INVALID_EMAIL", "Invalid email format")
                    )
                    return@post
                }
                
                // Validate username
                val usernameError = UsernameValidator.getValidationError(request.username)
                if (usernameError != null) {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        ErrorResponse("INVALID_USERNAME", usernameError)
                    )
                    return@post
                }
                
                // Validate password
                val passwordError = PasswordHasher.validatePasswordStrength(request.password)
                if (passwordError != null) {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        ErrorResponse("WEAK_PASSWORD", passwordError)
                    )
                    return@post
                }
                
                // Validate display name
                if (request.displayName.isBlank() || request.displayName.length > 100) {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        ErrorResponse("INVALID_DISPLAY_NAME", "Display name must be between 1 and 100 characters")
                    )
                    return@post
                }
                
                // Register user
                authService.register(request).fold(
                    onSuccess = { response ->
                        call.respond(HttpStatusCode.Created, response)
                    },
                    onFailure = { error ->
                        when (error.message) {
                            "Email already registered" -> {
                                call.respond(
                                    HttpStatusCode.Conflict,
                                    ErrorResponse("EMAIL_EXISTS", error.message ?: "Email already registered")
                                )
                            }
                            "Username already taken" -> {
                                call.respond(
                                    HttpStatusCode.Conflict,
                                    ErrorResponse("USERNAME_EXISTS", error.message ?: "Username already taken")
                                )
                            }
                            else -> {
                                call.respond(
                                    HttpStatusCode.InternalServerError,
                                    ErrorResponse("REGISTRATION_FAILED", error.message ?: "Registration failed")
                                )
                            }
                        }
                    }
                )
            } catch (e: Exception) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    ErrorResponse("BAD_REQUEST", e.message ?: "Invalid request")
                )
            }
        }
        
        /**
         * POST /api/auth/login
         * Login existing user
         */
        post("/login") {
            try {
                val request = call.receive<LoginRequest>()
                
                // Validate email
                if (!EmailValidator.isValid(request.email)) {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        ErrorResponse("INVALID_EMAIL", "Invalid email format")
                    )
                    return@post
                }
                
                // Login user
                authService.login(request).fold(
                    onSuccess = { response ->
                        call.respond(HttpStatusCode.OK, response)
                    },
                    onFailure = { error ->
                        call.respond(
                            HttpStatusCode.Unauthorized,
                            ErrorResponse("INVALID_CREDENTIALS", "Invalid email or password")
                        )
                    }
                )
            } catch (e: Exception) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    ErrorResponse("BAD_REQUEST", e.message ?: "Invalid request")
                )
            }
        }
        
        /**
         * POST /api/auth/refresh
         * Refresh access token
         */
        post("/refresh") {
            try {
                val request = call.receive<RefreshTokenRequest>()
                
                authService.refreshToken(request).fold(
                    onSuccess = { response ->
                        call.respond(HttpStatusCode.OK, response)
                    },
                    onFailure = { error ->
                        call.respond(
                            HttpStatusCode.Unauthorized,
                            ErrorResponse("INVALID_TOKEN", error.message ?: "Invalid refresh token")
                        )
                    }
                )
            } catch (e: Exception) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    ErrorResponse("BAD_REQUEST", e.message ?: "Invalid request")
                )
            }
        }
        
        /**
         * POST /api/auth/logout
         * Logout user (revoke refresh token)
         */
        post("/logout") {
            try {
                val request = call.receive<RefreshTokenRequest>()
                
                authService.logout(request.refreshToken).fold(
                    onSuccess = {
                        call.respond(HttpStatusCode.OK, mapOf("message" to "Logged out successfully"))
                    },
                    onFailure = { error ->
                        call.respond(
                            HttpStatusCode.InternalServerError,
                            ErrorResponse("LOGOUT_FAILED", error.message ?: "Logout failed")
                        )
                    }
                )
            } catch (e: Exception) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    ErrorResponse("BAD_REQUEST", e.message ?: "Invalid request")
                )
            }
        }
    }
}
