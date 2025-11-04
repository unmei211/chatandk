package com.subby.chatandk.backend.shared.sso.client.initialize.bootstrap

import com.subby.chatandk.backend.shared.sso.client.SSOClientContext
import com.subby.chatandk.backend.shared.sso.client.config.properties.SsoClientBootstrapProperty
import com.subby.chatandk.backend.sso_client_registry.service.ISSORegistryService
import org.keycloak.OAuth2Constants
import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.KeycloakBuilder

class SimpleClientBootstrap(
    private val ssoRegistryService: ISSORegistryService,
    private val ssoClientProperties: SsoClientBootstrapProperty,
) : ISSOClientBootstrap {
    override fun bootstrap(): SSOClientContext {
        val selfSecret = ssoRegistryService.getClientSecretOrCreateClient(
            clientId = ssoClientProperties.client.clientId,
            clientName = ssoClientProperties.client.clientName,
            targetRealm = ssoClientProperties.realm.name
        )

        val keycloak = KeycloakBuilder
            .builder()
            .serverUrl(ssoClientProperties.ssoService.url)
            .realm(ssoClientProperties.realm.name)
            .clientId(ssoClientProperties.client.clientId)
            .clientSecret(selfSecret.secret)
            .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
            .build()

        val realm = keycloak.realm(ssoClientProperties.realm.name)
        val client = realm.clients().get(realm.clients().findByClientId(ssoClientProperties.client.clientId).first().id)
        val clientUser = client.serviceAccountUser

        realm.roles().list().
        return SSOClientContext(
            client = client,
            realm = realm,
            clientUser = clientUser,
            keycloak = keycloak
        )
    }
}