package com.subby.chatandk.backend.core.websocket.messaging

data class WebSocketMessageContext(
    val headers: Map<String, Any> = emptyMap(),
) {
}