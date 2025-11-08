package com.subby.chatandk.backend.chat.internal.api.websocket

import com.subby.chatandk.backend.chat.api.websocket.IChatWebSocketBridge
import com.subby.chatandk.backend.core.messaging.publisher.IMessagePublisher
import com.subby.chatandk.backend.core.websocket.messaging.WebSocketMessageContext
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.stereotype.Controller

@Controller
class ChatWebSocketBridge(
    private val publisher: IMessagePublisher<WebSocketMessageContext>,
) : IChatWebSocketBridge {

    @MessageMapping("/chat/{chatId}/operation/message")
    override fun handleMessageOperation(
        @DestinationVariable chatId: String
    ) {
        println("flakj")
        publisher.publish("/topic/chat/${chatId}", "abobas")
    }

    @SubscribeMapping("/topic/chat/{chatId}")
    fun chatSubscriptionHandler(
        @DestinationVariable chatId: String
    ) {
        println("chatSubscriptionHandler")
    }
}