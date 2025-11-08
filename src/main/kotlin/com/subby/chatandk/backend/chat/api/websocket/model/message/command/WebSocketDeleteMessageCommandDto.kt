package com.subby.chatandk.backend.chat.api.websocket.model.message.command

data class WebSocketDeleteMessageCommandDto(
    val args: Arg
) : IWebSocketMessageCommandMarker {
    override fun getCommandType(): String = "message.delete"

    override fun getArgs(): Any = args

    data class Arg(
        val messageId: String,
        val deleteFromAll: Boolean = false
    )
}