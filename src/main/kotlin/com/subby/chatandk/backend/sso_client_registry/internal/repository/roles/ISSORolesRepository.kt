package com.subby.chatandk.backend.sso_client_registry.internal.repository.roles

import org.keycloak.representations.idm.RoleRepresentation
import org.keycloak.representations.idm.RolesRepresentation

interface ISSORolesRepository {
    fun grantServiceClientPermissions(
        roles: List<RoleRepresentation>,
        clientUserId: String,
        sourceClient: String,
        realm: String
    )

    fun getClientRoles(clientInternalId: String, realm: String): List<RoleRepresentation>
}