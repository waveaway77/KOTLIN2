package org.example.org.example.utils.logger

import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger {}

class OshaiLogging {
    val message = "world"
    fun bar() {
        logger.error { "hello $message" } // 14:19:27.429 [main] ERROR org.example.org.example.utils.logger.OshaiLogging -- hello world
    }
}

fun main(args: Array<String>) = OshaiLogging().bar()