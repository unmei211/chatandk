package com.subby.chatandk.backend.auth.internal.config.sso.bootstrap

import com.subby.chatandk.backend.sso.sdk.client.SSOClientContext
import com.subby.chatandk.backend.sso.sdk.client.properties.SsoClientBootstrapProperty
import com.subby.chatandk.backend.sso.sdk.client.initialize.bootstrap.ISSOClientBootstrap
import com.subby.chatandk.backend.sso.sdk.client.initialize.bootstrap.SimpleClientBootstrap
import com.subby.chatandk.backend.sso.registry.service.ISSORegistryService
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