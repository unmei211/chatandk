package com.subby.chatandk.backend.core.websocket.publisher

import com.subby.chatandk.backend.core.websocket.messaging.WebSocketMessageContext
import org.springframework.messaging.simp.SimpMessagingTemplate

class SimpleWSMessagePublisher(
    private val messagingTemplate: SimpMessagingTemplate,
) : IWebSocketMessagePublisher {
    override fun publish(destination: String, payload: Any) {
        messagingTemplate.convertAndSend(destination, payload)
    }

    override fun publish(
        destination: String,
        payload: Any,
        context: WebSocketMessageContext?
    ) {
        messagingTemplate.convertAndSend(destination, payload)
    }
}