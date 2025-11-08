package com.subby.chatandk.backend.sso.registry.internal.config.properties.admin.realm

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "modules.sso-client-registry.admin.realm")
data class SsoAdminRealmConfigurationProperties(
    val name: String
)