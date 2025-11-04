package com.subby.chatandk.backend.shared.sso.client

import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.resource.ClientResource
import org.keycloak.admin.client.resource.RealmResource
import org.keycloak.admin.client.resource.UserResource
import org.keycloak.representations.idm.UserRepresentation

class SSOClientContext(
    val client: ClientResource,
    val realm: RealmResource,
    val clientUser: UserRepresentation,
    val keycloak: Keycloak
) {
}