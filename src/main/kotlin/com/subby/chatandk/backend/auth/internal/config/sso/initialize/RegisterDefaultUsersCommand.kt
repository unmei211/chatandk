package com.subby.chatandk.backend.auth.internal.config.sso.initialize

import com.subby.chatandk.backend.sso.sdk.client.service.ISSOClientService
import com.subby.chatandk.backend.sso.sdk.client.initialize.postbootstrap.InitializeClientCommand
import org.springframework.stereotype.Component

@Component
class RegisterDefaultUsersCommand(
    private val ssoClientService: ISSOClientService
) : InitializeClientCommand {
    override fun execute() = ssoClientService.registerDefaultUsers()
}