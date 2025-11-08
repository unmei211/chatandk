package com.subby.chatandk.backend.chat.api.websocket.model.message.command

interface IWebSocketMessageCommandMarker {
    fun getCommandType(): String
    fun getArgs(): Any
}