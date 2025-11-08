package com.subby.chatandk.backend.sso.sdk.client.properties

data class SsoClientBootstrapProperty(
    val client: SsoClientBootstrapClientProperty,
    val realm: SsoClientBootstrapRealmProperty,
    val ssoService: SsoClientBootstrapSsoServiceProperty,
    val roles: List<String>,
) {
}