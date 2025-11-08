package com.subby.chatandk.backend.core.exception.http

class NotFoundException(
    message: String,
    cause: Throwable? = null,
    val errors: List<String> = emptyList(),
) : RuntimeException(message, cause)
