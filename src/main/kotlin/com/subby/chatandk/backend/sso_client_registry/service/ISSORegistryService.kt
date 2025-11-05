package com.subby.chatandk.backend.sso_client_registry.service

import org.keycloak.representations.idm.ClientRepresentation

interface ISSORegistryService {
    fun createSSOClient(client: ClientRepresentation, realm: String): ClientRepresentation
    fun getOrCreateClient(
        clientId: String,
        clientName: String,
        targetRealm: String
    ): ClientRepresentation
}