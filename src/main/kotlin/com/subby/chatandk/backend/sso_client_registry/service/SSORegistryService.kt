package com.subby.chatandk.backend.sso_client_registry.service

import com.subby.chatandk.backend.shared.exception.app.ServiceException
import com.subby.chatandk.backend.shared.exception.http.NotFoundException
import com.subby.chatandk.backend.sso_client_registry.config.properties.SsoClientRegistryConfigurationProperties
import com.subby.chatandk.backend.sso_client_registry.config.properties.sso_service.SsoClientRegistryServiceConfigurationProperties
import com.subby.chatandk.backend.sso_client_registry.internal.repository.client_registry.ISSOClientRegistryRepository
import com.subby.chatandk.backend.sso_client_registry.internal.repository.realm.ISSORealmRepository
import com.subby.chatandk.backend.sso_client_registry.internal.repository.roles.ISSORolesRepository
import com.subby.chatandk.backend.sso_client_registry.service.model.SSOClientSecretModel
import org.keycloak.admin.client.resource.RealmResource
import org.keycloak.representations.idm.ClientRepresentation
import org.keycloak.representations.idm.RoleRepresentation
import org.springframework.stereotype.Service

@Service
class SSORegistryService(
    private val realmRepository: ISSORealmRepository,
    private val clientRepository: ISSOClientRegistryRepository,
    private val rolesRepository: ISSORolesRepository,
    private val conf: SsoClientRegistryConfigurationProperties
) : ISSORegistryService {
    override fun createSSOClient(client: ClientRepresentation, realm: String): ClientRepresentation {
        val createdClient = clientRepository.createClient(client, realm)

        val clientUser = realmRepository.findRealmByName(realm)!!.clients().get(createdClient.id).serviceAccountUser

        val realmManagementClient =
            clientRepository.findClientById(conf.clientCreation.roleGrant.sourceClient.clientId, realm)

        val managementClientRolesMap: Map<String, RoleRepresentation> =
            rolesRepository.getClientRoles(realmManagementClient?.id ?: "", realm).associateBy { it.name }

        val requiredRoles = conf.clientCreation.roleGrant.roles

        val rolesToAssign: List<RoleRepresentation> = requiredRoles.map {
            val targetRole: RoleRepresentation = managementClientRolesMap[it]
                ?: throw ServiceException("Required role $it does not exist in realm $realmManagementClient")
            return@map targetRole
        }

        rolesRepository.grantServiceClientPermissions(
            roles = rolesToAssign,
            clientUserId = clientUser.id,
            sourceClient = realmManagementClient?.id ?: "",
            realm = realm
        )

        return createdClient
    }

    override fun getOrCreateClient(
        clientId: String,
        clientName: String,
        targetRealm: String
    ): ClientRepresentation {
        val realm: RealmResource = realmRepository.findRealmByName(targetRealm)
            ?: throw NotFoundException("Realm does not exist: $targetRealm")

        val client: ClientRepresentation = clientRepository.findClientById(clientId, targetRealm) ?: let {
            val newClient = ClientRepresentation().let {
                it.clientId = clientId
                it.name = clientName
                it.isPublicClient = false
                it.protocol = "openid-connect"
                it.isServiceAccountsEnabled = true
                return@let it
            }
            val createdClient = this.createSSOClient(newClient, targetRealm)
            return@let createdClient
        }

        return client
    }
}