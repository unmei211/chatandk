package com.subby.chatandk.backend.shared.sso.client.service

import com.subby.chatandk.backend.shared.sso.client.roles.UserRole

interface ISSOClientService {
    fun registerDefaultUsers()

    fun upsertRoles(roles: List<UserRole>)
}