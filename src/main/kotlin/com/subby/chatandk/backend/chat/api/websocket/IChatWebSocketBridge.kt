package com.subby.chatandk.backend.chat.api.websocket

interface IChatWebSocketBridge {
    fun handleMessageOperation(chatId: String)
}