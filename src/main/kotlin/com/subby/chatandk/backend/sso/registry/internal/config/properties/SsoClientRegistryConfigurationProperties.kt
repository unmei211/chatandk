package com.subby.chatandk.backend.sso.registry.internal.config.properties

import com.subby.chatandk.backend.sso.registry.internal.config.properties.admin.SsoAdminConfigurationProperties
import com.subby.chatandk.backend.sso.registry.internal.config.properties.client_creation.SsoClientCreationProperties
import com.subby.chatandk.backend.sso.registry.internal.config.properties.sso_service.SsoClientRegistryServiceConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "modules.sso-client-registry")
data class SsoClientRegistryConfigurationProperties(
    val admin: SsoAdminConfigurationProperties,
    val ssoService: SsoClientRegistryServiceConfigurationProperties,
    val clientCreation: SsoClientCreationProperties,
) {
}