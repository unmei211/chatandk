package com.subby.chatandk.backend.core.messaging.publisher

interface IMessagePublisher<C> {
    fun publish(destination: String, payload: Any)
    fun publish(destination: String, payload: Any, context: C? = null)
}