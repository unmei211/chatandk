package com.subby.chatandk.backend.sso.registry.internal.config

import com.subby.chatandk.backend.sso.registry.internal.config.properties.SsoClientRegistryConfigurationProperties
import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.KeycloakBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KeycloakAdminConfiguration(
    private val conf: SsoClientRegistryConfigurationProperties
) {
    @Bean("keycloakAdminClient")
    fun keycloakAdminClient(): Keycloak {
        val keycloak = KeycloakBuilder
            .builder()
            .serverUrl(conf.ssoService.url)
            .realm(conf.admin.realm.name)
            .clientId("admin-cli")
            .username(conf.admin.credentials.username)
            .password(conf.admin.credentials.password)
            .build()

        return keycloak
    }
}