package com.subby.chatandk.backend.core.exception.app


class ApiAdapterException(
    message: String? = null,
    cause: Throwable? = null,
) : RuntimeException(message, cause)
