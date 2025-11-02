package com.picnic.server.data.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Database configuration and connection management
 */
object DatabaseFactory {
    
    fun init(
        url: String,
        driver: String,
        user: String,
        password: String,
        maxPoolSize: Int = 10
    ) {
        val database = Database.connect(
            createHikariDataSource(url, driver, user, password, maxPoolSize)
        )
        
        transaction(database) {
            // Create all tables
            SchemaUtils.create(
                Users,
                RefreshTokens,
                EmailVerificationTokens,
                PasswordResetTokens,
                Posts,
                MediaAttachments,
                Follows,
                FollowRequests,
                Likes,
                Comments,
                Bookmarks
            )
        }
    }
    
    private fun createHikariDataSource(
        url: String,
        driver: String,
        user: String,
        password: String,
        maxPoolSize: Int
    ): HikariDataSource {
        val config = HikariConfig().apply {
            driverClassName = driver
            jdbcUrl = url
            username = user
            this.password = password
            maximumPoolSize = maxPoolSize
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }
        return HikariDataSource(config)
    }
}
