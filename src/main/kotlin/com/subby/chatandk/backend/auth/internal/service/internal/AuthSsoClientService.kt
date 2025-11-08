package com.subby.chatandk.backend.auth.internal.service.internal

import com.subby.chatandk.backend.sso.sdk.client.SSOClientContext
import com.subby.chatandk.backend.sso.sdk.client.properties.SsoClientBootstrapProperty
import com.subby.chatandk.backend.sso.sdk.client.roles.UserRole
import com.subby.chatandk.backend.sso.sdk.client.service.ISSOClientService
import org.keycloak.representations.idm.RoleRepresentation
import org.springframework.stereotype.Service

@Service
class AuthSsoClientService(
    private val config: SsoClientBootstrapProperty,
    private val ssoContext: SSOClientContext
) : ISSOClientService {
    override fun registerDefaultUsers() {
        TODO("Not yet implemented")
    }

    override fun upsertRoles(roles: List<UserRole>) {
        val rolesSource = ssoContext.realm.roles()
        val realmRoles: Set<String> = setOf(*(rolesSource.list().map { it.name }).toTypedArray())
        val configRoles = setOf(*(roles.map { it.role }).toTypedArray())

        val upsertRoles = (configRoles - realmRoles).toList().map { role -> UserRole(role) }

        upsertRoles.forEach {
            rolesSource.create(RoleRepresentation().apply { name = it.role })
        }
    }
}