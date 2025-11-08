package com.subby.chatandk.backend.core.exception.http

class BadRequestException(
    /**
     * The detail message explaining the reason for the exception, can be {@code null}.
     */
    message: String? = null,
    /**
     * The underlying cause of the exception, can be {@code null}.
     */
    cause: Throwable? = null,
    val errors: List<String> = emptyList(),
) : RuntimeException(message, cause)
