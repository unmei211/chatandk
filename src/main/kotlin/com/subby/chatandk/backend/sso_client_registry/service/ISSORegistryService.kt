package com.subby.chatandk.backend.sso_client_registry.service

import com.subby.chatandk.backend.sso_client_registry.service.model.SSOClientSecretModel
import org.keycloak.representations.idm.ClientRepresentation

interface ISSORegistryService {
    fun createSSOClient(client: ClientRepresentation, realm: String): ClientRepresentation
    fun getClientSecretOrCreateClient(
        clientId: String,
        clientName: String,
        targetRealm: String
    ): SSOClientSecretModel
}