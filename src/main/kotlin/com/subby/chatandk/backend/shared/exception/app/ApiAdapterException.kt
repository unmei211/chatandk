package com.subby.chatandk.backend.shared.exception.app


class ApiAdapterException(
    message: String? = null,
    cause: Throwable? = null,
) : RuntimeException(message, cause)
