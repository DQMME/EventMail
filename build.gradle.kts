import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "de.dqmme"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    implementation(kotlin("stdlib"))

    compileOnly("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")

    compileOnly("net.axay:simplekotlinmail-core:1.4.0")
    compileOnly("net.axay:simplekotlinmail-client:1.4.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

bukkit {
    name = "EventMail"
    apiVersion = "1.19"
    authors = listOf(
        "DQMME",
    )
    main = "$group.eventmail.EventMail"
    version = getVersion().toString()
    libraries = listOf(
        "net.axay:simplekotlinmail-core:1.4.0",
        "net.axay:simplekotlinmail-client:1.4.0"
    )
}