package com.subby.chatandk.backend.shared.exception.http

class NotFoundException(
    message: String,
    cause: Throwable? = null,
    val errors: List<String> = emptyList(),
) : RuntimeException(message, cause)
