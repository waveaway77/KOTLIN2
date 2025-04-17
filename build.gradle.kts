plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.20")
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))

    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")

    implementation("org.mapstruct:mapstruct:1.5.5.Final")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}