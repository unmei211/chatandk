package com.subby.chatandk.backend.sso.registry.internal.repository.client_registry

import org.keycloak.representations.idm.ClientRepresentation

interface ISSOClientRegistryRepository {
    fun findClientById(clientId: String, realm: String): ClientRepresentation?
    fun createClient(client: ClientRepresentation, realm: String): ClientRepresentation
}