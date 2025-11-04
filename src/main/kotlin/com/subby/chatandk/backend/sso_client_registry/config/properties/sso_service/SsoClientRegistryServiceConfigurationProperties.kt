package com.subby.chatandk.backend.sso_client_registry.config.properties.sso_service

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "modules.sso-client-registry.sso-service")
data class SsoClientRegistryServiceConfigurationProperties(
    val url: String
) {
}