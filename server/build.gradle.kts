plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("io.ktor.plugin")
    application
}

group = "com.picnic.server"
version = "0.1.0-alpha"

application {
    mainClass.set("com.picnic.server.ApplicationKt")
    
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    // Ktor Server
    implementation("io.ktor:ktor-server-core:2.3.6")
    implementation("io.ktor:ktor-server-netty:2.3.6")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.6")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.6")
    implementation("io.ktor:ktor-server-auth:2.3.6")
    implementation("io.ktor:ktor-server-auth-jwt:2.3.6")
    implementation("io.ktor:ktor-server-cors:2.3.6")
    implementation("io.ktor:ktor-server-compression:2.3.6")
    implementation("io.ktor:ktor-server-call-logging:2.3.6")
    implementation("io.ktor:ktor-server-status-pages:2.3.6")
    implementation("io.ktor:ktor-server-websockets:2.3.6")
    implementation("io.ktor:ktor-server-rate-limit:2.3.6")
    
    // Database - Exposed ORM
    implementation("org.jetbrains.exposed:exposed-core:0.44.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.44.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.44.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.44.1")
    
    // PostgreSQL
    implementation("org.postgresql:postgresql:42.6.0")
    
    // HikariCP - Connection Pool
    implementation("com.zaxxer:HikariCP:5.1.0")
    
    // Redis for caching
    implementation("io.lettuce:lettuce-core:6.3.0.RELEASE")
    
    // BCrypt for password hashing
    implementation("org.mindrot:jbcrypt:0.4")
    
    // Logback for logging
    implementation("ch.qos.logback:logback-classic:1.4.11")
    
    // Kotlinx Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    
    // Kotlinx DateTime
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
    
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    
    // AWS SDK for S3 (media storage)
    implementation("aws.sdk.kotlin:s3:1.0.0")
    
    // Email (SendGrid)
    implementation("com.sendgrid:sendgrid-java:4.10.1")
    
    // Testing
    testImplementation("io.ktor:ktor-server-test-host:2.3.6")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.20")
    testImplementation("io.mockk:mockk:1.13.8")
}

kotlin {
    jvmToolchain(17)
}
