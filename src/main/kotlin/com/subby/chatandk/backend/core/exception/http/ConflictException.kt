package com.subby.chatandk.backend.core.exception.http

class ConflictException(
    message: String,
    cause: Throwable? = null,
    val errors: List<String> = emptyList(),
    val errorCode: String? = null,
) : RuntimeException(message, cause)
