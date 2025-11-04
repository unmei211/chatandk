package com.subby.chatandk.backend.auth.config.initialize

import com.subby.chatandk.backend.auth.config.SSOClientPropertiesConfig
import com.subby.chatandk.backend.shared.sso.client.config.properties.SsoClientBootstrapProperty
import com.subby.chatandk.backend.shared.sso.client.initialize.postbootstrap.InitializeClientCommand
import com.subby.chatandk.backend.shared.sso.client.roles.UserRole
import com.subby.chatandk.backend.shared.sso.client.service.ISSOClientService
import org.springframework.beans.factory.InitializingBean
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