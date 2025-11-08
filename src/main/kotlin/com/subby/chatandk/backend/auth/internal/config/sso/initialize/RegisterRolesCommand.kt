package com.subby.chatandk.backend.auth.internal.config.sso.initialize

import com.subby.chatandk.backend.sso.sdk.client.properties.SsoClientBootstrapProperty
import com.subby.chatandk.backend.sso.sdk.client.initialize.postbootstrap.InitializeClientCommand
import com.subby.chatandk.backend.sso.sdk.client.roles.UserRole
import com.subby.chatandk.backend.sso.sdk.client.service.ISSOClientService
import org.springframework.stereotype.Component

@Component
class RegisterRolesCommand(
    private val config: SsoClientBootstrapProperty,
    private val ssoClientService: ISSOClientService
) : InitializeClientCommand {
    override fun execute() {
        val roles = config.roles.map { role -> UserRole(role) }
        ssoClientService.upsertRoles(roles)
    }
}