package com.subby.chatandk.backend.sso_client_registry.config.properties.admin.credentials

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "modules.sso-client-registry.admin.credentials")
data class SsoAdminCredentialsConfigurationProperties(
    val password: String,
    val username: String
) {
}