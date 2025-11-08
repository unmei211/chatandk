package com.subby.chatandk.backend.sso.registry.internal.repository.realm

import org.keycloak.admin.client.resource.RealmResource

interface ISSORealmRepository {
    fun findRealmByName(realmName: String): RealmResource?
}