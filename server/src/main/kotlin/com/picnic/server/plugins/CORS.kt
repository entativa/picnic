package com.picnic.server.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*

/**
 * Configure CORS (Cross-Origin Resource Sharing)
 */
fun Application.configureCORS() {
    install(CORS) {
        // Allow common HTTP methods
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)
        allowMethod(HttpMethod.Options)
        
        // Allow common headers
        allowHeader(HttpHeaders.Authorization)
        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.Accept)
        
        // Allow credentials (cookies, authorization headers)
        allowCredentials = true
        
        // Allow any host in development (restrict in production)
        anyHost()
        
        // Max age for preflight requests
        maxAgeInSeconds = 3600
    }
}
