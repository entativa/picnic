package com.picnic.server.plugins

import com.picnic.server.util.JwtConfig
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*

/**
 * Configure JWT authentication
 */
fun Application.configureSecurity(jwtConfig: JwtConfig) {
    
    authentication {
        jwt("auth-jwt") {
            realm = jwtConfig.realm
            verifier(jwtConfig.verifier)
            
            validate { credential ->
                // Validate that the token has the required claims
                val userId = credential.payload.subject
                val tokenType = credential.payload.getClaim("type").asString()
                
                if (userId != null && tokenType == "access") {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
            
            challenge { _, _ ->
                call.respond(HttpStatusCode.Unauthorized, mapOf("error" to "Token is not valid or has expired"))
            }
        }
    }
}

/**
 * Extension to get user ID from JWT principal
 */
val ApplicationCall.userId: String
    get() = principal<JWTPrincipal>()?.subject
        ?: throw IllegalStateException("No user ID found in JWT")
