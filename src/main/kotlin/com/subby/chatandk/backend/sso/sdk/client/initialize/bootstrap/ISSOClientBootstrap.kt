package com.subby.chatandk.backend.sso.sdk.client.initialize.bootstrap

import com.subby.chatandk.backend.sso.sdk.client.SSOClientContext

interface ISSOClientBootstrap {
    fun bootstrap(): SSOClientContext
}