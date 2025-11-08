package com.subby.chatandk.backend.sso.registry.internal.repository.roles

import org.keycloak.representations.idm.RoleRepresentation

interface ISSORolesRepository {
    fun grantServiceClientPermissions(
        roles: List<RoleRepresentation>,
        clientUserId: String,
        sourceClient: String,
        realm: String
    )

    fun getClientRoles(clientInternalId: String, realm: String): List<RoleRepresentation>
}