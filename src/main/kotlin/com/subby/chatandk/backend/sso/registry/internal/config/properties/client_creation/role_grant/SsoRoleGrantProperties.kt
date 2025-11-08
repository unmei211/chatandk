package com.subby.chatandk.backend.sso.registry.internal.config.properties.client_creation.role_grant

import com.subby.chatandk.backend.sso.registry.internal.config.properties.client_creation.role_grant.source_client.SsoRoleGrantSourceClientProperties


data class SsoRoleGrantProperties(
    val sourceClient: SsoRoleGrantSourceClientProperties,
    val roles: List<String>
) {
}