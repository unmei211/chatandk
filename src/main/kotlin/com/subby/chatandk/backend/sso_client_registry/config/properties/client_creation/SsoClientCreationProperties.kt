package com.subby.chatandk.backend.sso_client_registry.config.properties.client_creation

import com.subby.chatandk.backend.sso_client_registry.config.properties.client_creation.role_grant.SsoRoleGrantProperties

data class SsoClientCreationProperties(
    val roleGrant: SsoRoleGrantProperties,
) {
}