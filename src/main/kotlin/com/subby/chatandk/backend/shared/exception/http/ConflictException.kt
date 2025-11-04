package com.subby.chatandk.backend.shared.exception.http

class ConflictException(
    message: String,
    cause: Throwable? = null,
    val errors: List<String> = emptyList(),
    val errorCode: String? = null,
) : RuntimeException(message, cause)
