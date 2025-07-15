package org.example.org.example.utils.logger.mdc.practice

import kotlinx.coroutines.*
import org.slf4j.MDC

fun main() {
    not_working_MDC() // null
    working_MDC() // value
}

fun not_working_MDC(): Unit = runBlocking {
    launch(MDCContext()) {
        MDC.put("key", "value") // This update will be lost
        delay(100) // new coroutine scope
        println(MDC.get("key")) // This will print null
    }
}

fun working_MDC(): Unit = runBlocking {
    launch(MDCContext()) {
        MDC.put("key", "value") // This update will be lost
        withContext(MDCContext()) {
            delay(100) // new coroutine scope
            println(MDC.get("key"))
        }
    }
}