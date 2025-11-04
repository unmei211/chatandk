package com.subby.chatandk.backend.shared.sso.client.initialize.bootstrap

import com.subby.chatandk.backend.shared.sso.client.SSOClientContext

interface ISSOClientBootstrap {
    fun bootstrap(): SSOClientContext
}