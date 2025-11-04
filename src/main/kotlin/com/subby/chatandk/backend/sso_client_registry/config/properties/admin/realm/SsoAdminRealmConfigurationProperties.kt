package com.subby.chatandk.backend.sso_client_registry.config.properties.admin.realm

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "modules.sso-client-registry.admin.realm")
data class SsoAdminRealmConfigurationProperties(
    val name: String
)