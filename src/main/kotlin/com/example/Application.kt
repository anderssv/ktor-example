package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.jetty.*
import com.example.plugins.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Jetty, port = 8080, host = "0.0.0.0", module = {
        configureSecurity()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
        configureDatabases()
        configureRouting()
        routing {
            get("health") {
                // This one shows up
            }
        }
    }).start(wait = true)
}
