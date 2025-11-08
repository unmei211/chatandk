package com.subby.chatandk.backend.auth.internal.service.internal

interface IJwtService<T, C> {
    fun generateToken(user: T): String
    fun parseToken(token: String): C
}