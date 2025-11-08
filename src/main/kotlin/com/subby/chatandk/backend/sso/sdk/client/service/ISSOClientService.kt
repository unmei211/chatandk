package com.subby.chatandk.backend.sso.sdk.client.service

import com.subby.chatandk.backend.sso.sdk.client.roles.UserRole

interface ISSOClientService {
    fun registerDefaultUsers()

    fun upsertRoles(roles: List<UserRole>)
}