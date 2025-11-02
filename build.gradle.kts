plugins {
    // Kotlin Multiplatform
    kotlin("multiplatform") version "1.9.20" apply false
    kotlin("android") version "1.9.20" apply false
    
    // Compose Multiplatform
    id("org.jetbrains.compose") version "1.5.10" apply false
    
    // Android
    id("com.android.application") version "8.1.4" apply false
    id("com.android.library") version "8.1.4" apply false
    
    // Serialization
    kotlin("plugin.serialization") version "1.9.20" apply false
    
    // Ktor server
    id("io.ktor.plugin") version "2.3.6" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
