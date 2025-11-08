package com.subby.chatandk.backend.core.exception.http

class ForbiddenException(
    message: String,
    cause: Throwable?,
    val errors: List<String>,
) : RuntimeException(message, cause)
