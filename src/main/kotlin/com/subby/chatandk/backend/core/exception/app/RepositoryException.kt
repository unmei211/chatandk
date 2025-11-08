package com.subby.chatandk.backend.core.exception.app

class RepositoryException(
    /**
     * The detail message explaining the reason for the exception, can be {@code null}.
     */
    message: String? = null,
    /**
     * The underlying cause of the exception, can be {@code null}.
     */
    cause: Throwable? = null,
) : RuntimeException(message, cause)
