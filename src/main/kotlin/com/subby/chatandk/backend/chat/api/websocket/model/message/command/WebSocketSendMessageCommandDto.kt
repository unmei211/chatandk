package com.subby.chatandk.backend.chat.api.websocket.model.message.command

data class WebSocketSendMessageCommandDto(
    val args: Arg
) : IWebSocketMessageCommandMarker {
    override fun getCommandType(): String = "message.send"

    override fun getArgs(): Any = args

    data class Arg(
        val payload: String
    )
}