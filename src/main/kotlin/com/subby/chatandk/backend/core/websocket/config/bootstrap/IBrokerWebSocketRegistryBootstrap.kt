package com.subby.chatandk.backend.core.websocket.config.bootstrap

interface IBrokerWebSocketRegistryBootstrap {
    fun bootstrap(): List<String>
}