package com.subby.chatandk.backend.core.websocket.config.bootstrap

import org.springframework.web.socket.config.annotation.StompEndpointRegistry

interface IStompEndpointsBootstrap {
    fun bootstrap(brokerRegistry: StompEndpointRegistry)
}