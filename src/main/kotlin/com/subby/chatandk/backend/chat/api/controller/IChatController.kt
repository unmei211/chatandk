package com.subby.chatandk.backend.chat.api.controller

interface IChatController {
    fun createChat()
    fun deleteChat()
    fun editChat()

    fun addMember()
}