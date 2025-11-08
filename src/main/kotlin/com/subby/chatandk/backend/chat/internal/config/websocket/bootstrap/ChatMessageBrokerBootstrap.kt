package com.subby.chatandk.backend.chat.internal.config.websocket.bootstrap

import com.subby.chatandk.backend.core.websocket.config.bootstrap.IBrokerWebSocketRegistryBootstrap
import org.springframework.stereotype.Component

@Component
class ChatMessageBrokerBootstrap : IBrokerWebSocketRegistryBootstrap {
    override fun bootstrap(): List<String> {
        return listOf("/topic/chat")
    }
}