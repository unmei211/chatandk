package com.subby.chatandk.backend.app.config

import com.subby.chatandk.backend.core.websocket.config.bootstrap.IBrokerWebSocketRegistryBootstrap
import com.subby.chatandk.backend.core.websocket.config.bootstrap.IStompEndpointsBootstrap
import com.subby.chatandk.backend.core.websocket.publisher.IWebSocketMessagePublisher
import com.subby.chatandk.backend.core.websocket.publisher.SimpleWSMessagePublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfiguration(
    private val stompEndpointsBootstrap: List<IStompEndpointsBootstrap>,
    private val brokerMessageBootstrap: List<IBrokerWebSocketRegistryBootstrap>
) : WebSocketMessageBrokerConfigurer {
    override fun registerStompEndpoints(endpointRegistry: StompEndpointRegistry) {
        endpointRegistry
            .addEndpoint("/ws/stomp")
            .setAllowedOrigins("*")
//            .withSockJS()

        stompEndpointsBootstrap.forEach { it.bootstrap(endpointRegistry) }
    }

    override fun configureMessageBroker(brokerRegistry: MessageBrokerRegistry) {
        brokerRegistry.setApplicationDestinationPrefixes("/app")

        val brokerPaths = mutableListOf<String>()
        brokerMessageBootstrap.forEach { brokerPaths.addAll(it.bootstrap()) }

        brokerRegistry.enableSimpleBroker(*brokerPaths.toTypedArray())
    }

    @Bean
    fun websocketMessagePublisher(
        messagingTemplate: SimpMessagingTemplate,
    ): IWebSocketMessagePublisher {
        return SimpleWSMessagePublisher(messagingTemplate)
    }
}