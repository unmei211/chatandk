package com.subby.chatandk.backend.sso_client_registry.config.properties

import com.subby.chatandk.backend.sso_client_registry.config.properties.admin.SsoAdminConfigurationProperties
import com.subby.chatandk.backend.sso_client_registry.config.properties.client_creation.SsoClientCreationProperties
import com.subby.chatandk.backend.sso_client_registry.config.properties.sso_service.SsoClientRegistryServiceConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "modules.sso-client-registry")
data class SsoClientRegistryConfigurationProperties(
    val admin: SsoAdminConfigurationProperties,
    val ssoService: SsoClientRegistryServiceConfigurationProperties,
    val clientCreation: SsoClientCreationProperties,
) {
}