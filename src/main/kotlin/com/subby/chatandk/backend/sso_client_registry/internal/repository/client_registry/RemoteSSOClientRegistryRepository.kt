package com.subby.chatandk.backend.sso_client_registry.internal.repository.client_registry

import com.subby.chatandk.backend.shared.exception.app.RepositoryException
import org.keycloak.admin.client.Keycloak
import org.keycloak.representations.idm.ClientRepresentation
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository

@Repository
class RemoteSSOClientRegistryRepository(
    private val keycloakAdminClient: Keycloak
) : ISSOClientRegistryRepository {
    override fun findClientById(clientId: String, realm: String): ClientRepresentation? {
        val clients = keycloakAdminClient.realm(realm).clients().findByClientId(clientId)
        return if (clients.isEmpty()) {
            null
        } else {
            clients.first()
        }
    }

    override fun createClient(
        client: ClientRepresentation,
        realm: String
    ): ClientRepresentation {
        val response = keycloakAdminClient.realm(realm).clients().create(client)
        HttpStatus.valueOf(response.status).apply {
            if (is4xxClientError && is5xxServerError) {
                throw RepositoryException("4xx or 5xx server error")
            }
        }
        return this.findClientById(client.clientId, realm)
            ?: throw RepositoryException("Client ${client.clientId} not found")
    }
}