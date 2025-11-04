package com.subby.chatandk.backend.sso_client_registry.internal.repository.realm

import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.resource.RealmResource
import org.springframework.stereotype.Repository

@Repository
class RemoteSSORealmRepository(
    private val keycloakAdminClient: Keycloak
) : ISSORealmRepository {
    override fun findRealmByName(realmName: String): RealmResource? = try {
        keycloakAdminClient.realm(realmName)
    } catch (ex: Exception) {
        null
    }
}