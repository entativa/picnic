package com.picnic.server

import com.picnic.server.data.database.DatabaseFactory
import com.picnic.server.plugins.*
import com.picnic.server.services.AuthService
import com.picnic.server.util.JwtConfig
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    val config = HoconApplicationConfig(ConfigFactory.load())
    
    // Database configuration
    val dbUrl = config.property("database.url").getString()
    val dbDriver = config.property("database.driver").getString()
    val dbUser = config.property("database.user").getString()
    val dbPassword = config.property("database.password").getString()
    val dbMaxPoolSize = config.property("database.maxPoolSize").getString().toInt()
    
    // Initialize database
    DatabaseFactory.init(dbUrl, dbDriver, dbUser, dbPassword, dbMaxPoolSize)
    
    // JWT configuration
    val jwtSecret = config.property("jwt.secret").getString()
    val jwtIssuer = config.property("jwt.issuer").getString()
    val jwtAudience = config.property("jwt.audience").getString()
    val jwtRealm = config.property("jwt.realm").getString()
    val jwtAccessExpiration = config.property("jwt.accessTokenExpiration").getString().toLong()
    val jwtRefreshExpiration = config.property("jwt.refreshTokenExpiration").getString().toLong()
    
    val jwtConfig = JwtConfig(
        secret = jwtSecret,
        issuer = jwtIssuer,
        audience = jwtAudience,
        realm = jwtRealm,
        accessTokenExpiration = jwtAccessExpiration,
        refreshTokenExpiration = jwtRefreshExpiration
    )
    
    // Initialize services
    val authService = AuthService(jwtConfig)
    
    // Configure plugins
    configureSerialization()
    configureSecurity(jwtConfig)
    configureCORS()
    configureLogging()
    configureRouting(authService)
    
    log.info("🧺 Picnic Server started successfully!")
    log.info("Server running at: http://0.0.0.0:8080")
    log.info("API docs available at: http://0.0.0.0:8080/health")
}
