package com.subby.chatandk.backend.sso.registry.internal.repository.roles

import org.keycloak.admin.client.Keycloak
import org.keycloak.representations.idm.RoleRepresentation
import org.springframework.stereotype.Repository

@Repository
class RemoteSSORolesRepository(
    private val keycloakAdminClient: Keycloak
) : ISSORolesRepository {
    override fun grantServiceClientPermissions(
        roles: List<RoleRepresentation>,
        clientUserId: String,
        sourceClient: String,
        realm: String
    ) {
            keycloakAdminClient
                .realm(realm)
                .users()
                .get(clientUserId)
                .roles()
                .clientLevel(sourceClient)
                .add(roles)
    }

    override fun getClientRoles(
        clientInternalId: String,
        realm: String
    ): List<RoleRepresentation> {
        val clientRoles: List<RoleRepresentation?> = keycloakAdminClient
            .realm(realm)
            .clients()
            .get(clientInternalId)
            .roles().list()
            ?: emptyList()

        val filtered: List<RoleRepresentation> = clientRoles.filterNotNull()

        return filtered
    }
}