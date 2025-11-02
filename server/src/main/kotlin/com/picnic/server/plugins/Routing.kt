package com.picnic.server.plugins

import com.picnic.server.routes.authRoutes
import com.picnic.server.services.AuthService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * Configure application routes
 */
fun Application.configureRouting(authService: AuthService) {
    routing {
        
        // Health check endpoint
        get("/") {
            call.respondText("Picnic API is running! 🧺")
        }
        
        get("/health") {
            call.respond(
                mapOf(
                    "status" to "healthy",
                    "version" to "0.1.0-alpha",
                    "timestamp" to System.currentTimeMillis()
                )
            )
        }
        
        // API routes
        route("/api") {
            authRoutes(authService)
            
            // Protected routes (require authentication)
            authenticate("auth-jwt") {
                route("/users") {
                    get("/me") {
                        val userId = call.userId
                        val user = authService.getUserById(userId)
                        if (user != null) {
                            call.respond(user)
                        } else {
                            call.respond(io.ktor.http.HttpStatusCode.NotFound, mapOf("error" to "User not found"))
                        }
                    }
                }
            }
        }
    }
}
