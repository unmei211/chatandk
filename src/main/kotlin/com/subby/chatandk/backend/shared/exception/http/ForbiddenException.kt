package com.subby.chatandk.backend.shared.exception.http

class ForbiddenException(
    message: String,
    cause: Throwable?,
    val errors: List<String>,
) : RuntimeException(message, cause)
