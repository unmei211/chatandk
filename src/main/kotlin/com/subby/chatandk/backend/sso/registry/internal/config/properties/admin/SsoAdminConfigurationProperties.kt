package com.subby.chatandk.backend.sso.registry.internal.config.properties.admin

import com.subby.chatandk.backend.sso.registry.internal.config.properties.admin.credentials.SsoAdminCredentialsConfigurationProperties
import com.subby.chatandk.backend.sso.registry.internal.config.properties.admin.realm.SsoAdminRealmConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "modules.sso-client-registry.admin")
data class SsoAdminConfigurationProperties(
    val credentials: SsoAdminCredentialsConfigurationProperties,
    val realm: SsoAdminRealmConfigurationProperties
) {
}