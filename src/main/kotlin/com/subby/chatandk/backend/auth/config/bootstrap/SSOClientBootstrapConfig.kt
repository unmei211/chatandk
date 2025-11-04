package com.subby.chatandk.backend.auth.config.bootstrap

import com.subby.chatandk.backend.shared.sso.client.SSOClientContext
import com.subby.chatandk.backend.shared.sso.client.config.properties.SsoClientBootstrapProperty
import com.subby.chatandk.backend.shared.sso.client.initialize.bootstrap.ISSOClientBootstrap
import com.subby.chatandk.backend.shared.sso.client.initialize.bootstrap.SimpleClientBootstrap
import com.subby.chatandk.backend.sso_client_registry.service.ISSORegistryService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SSOClientBootstrapConfig(
    private val ssoRegistryService: ISSORegistryService,
    private val ssoClientProperties: SsoClientBootstrapProperty
) {
    @Bean
    fun ssoBootstrap(): ISSOClientBootstrap {
        return SimpleClientBootstrap(
            ssoRegistryService = ssoRegistryService,
            ssoClientProperties = ssoClientProperties
        )
    }

    @Bean
    fun ssoClientContext(
        ssoBootstrap: ISSOClientBootstrap,
    ): SSOClientContext {
        return ssoBootstrap.bootstrap()
    }

    private data class BootstrapUser(val username: String, val password: String, val roles: List<String>)
}