package com.subby.chatandk.backend.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker

@SpringBootApplication(scanBasePackages = ["com.subby.chatandk.backend"])
@EnableConfigurationProperties
@ConfigurationPropertiesScan(
    basePackages = ["com.subby.chatandk.backend"]
)
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}
