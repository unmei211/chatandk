package com.subby.chatandk.backend.auth.config.initialize

import com.subby.chatandk.backend.shared.sso.client.service.ISSOClientService
import com.subby.chatandk.backend.shared.sso.client.initialize.postbootstrap.InitializeClientCommand
import org.springframework.stereotype.Component

@Component
class RegisterDefaultUsersCommand(
    private val ssoClientService: ISSOClientService
) : InitializeClientCommand {
    override fun execute() = ssoClientService.registerDefaultUsers()
}