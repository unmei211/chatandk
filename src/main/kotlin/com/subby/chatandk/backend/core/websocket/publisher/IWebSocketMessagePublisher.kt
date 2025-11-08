package com.subby.chatandk.backend.core.websocket.publisher

import com.subby.chatandk.backend.core.messaging.publisher.IMessagePublisher
import com.subby.chatandk.backend.core.websocket.messaging.WebSocketMessageContext

interface IWebSocketMessagePublisher : IMessagePublisher<WebSocketMessageContext> {
    override fun publish(destination: String, payload: Any)
    override fun publish(
        destination: String,
        payload: Any,
        context: WebSocketMessageContext?
    )
}