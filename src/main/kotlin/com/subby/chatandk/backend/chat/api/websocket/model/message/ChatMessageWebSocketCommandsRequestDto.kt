package com.subby.chatandk.backend.chat.api.websocket.model.message

import com.subby.chatandk.backend.chat.api.websocket.model.message.command.IWebSocketMessageCommandMarker

data class ChatMessageWebSocketCommandsRequestDto(
    val operationId: String,
    val commands: List<IWebSocketMessageCommandMarker>
)