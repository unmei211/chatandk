package com.subby.chatandk.backend.auth.api.module

interface IUserRegistrationService {
    fun createPendingUser()

    fun initSmsVerify()
    fun verifySmsCode()

    fun initEmailVerify()
    fun verifyEmailCode()

    fun registerUser()
}