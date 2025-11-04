package com.subby.chatandk.backend.shared.sso.client.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

data class SsoClientBootstrapProperty(
    val client: SsoClientBootstrapClientProperty,
    val realm: SsoClientBootstrapRealmProperty,
    val ssoService: SsoClientBootstrapSsoServiceProperty,
    val roles: List<String>,
) {
}