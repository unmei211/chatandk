package com.subby.chatandk.backend.auth.config

import com.subby.chatandk.backend.shared.sso.client.config.properties.SsoClientBootstrapProperty
import org.springframework.boot.context.properties.bind.Bindable
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class SSOClientPropertiesConfig {

    private fun bindProperties(env: Environment, prefix: String): SsoClientBootstrapProperty {
        return Binder.get(env)
            .bind(prefix, Bindable.of(SsoClientBootstrapProperty::class.java))
            .orElseThrow {
                IllegalStateException("Can't load properties by prefix: $prefix")
            }
    }

    @Bean
    fun authSsoClientConfigurationProperties(env: Environment): SsoClientBootstrapProperty {
        return bindProperties(env, "modules.auth.sso-client-bootstrap")
    }
}