package com.subby.chatandk.backend.auth.internal.service.internal

import com.subby.chatandk.backend.auth.internal.service.model.PendingUserCredentialsModel
import com.subby.chatandk.backend.auth.internal.service.model.PendingUserModel
import io.jsonwebtoken.Jwt
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys

import org.springframework.stereotype.Service
import java.security.Key
import java.security.KeyFactory
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.Date

@Service
class PendingUserJwtService(
) : IJwtService<PendingUserModel, PendingUserCredentialsModel> {
    override fun generateToken(user: PendingUserModel): String {
        val now = OffsetDateTime.now().withOffsetSameInstant(ZoneOffset.UTC)
        val exp = now.plusMinutes(1)

        val key = Keys.hmacShaKeyFor("secretKey".toByteArray())

        val claims = mapOf<String, Any>(
            "userId" to user.id,
            "verifyStage" to "required",
        )

        val jwt = Jwts
            .builder()
            .issuedAt(Date.from(now.toInstant()))
            .expiration(Date.from(exp.toInstant()))
            .claims(claims)
            .signWith(
                key, Jwts.SIG.HS512
            )
            .compact()

        return jwt
    }

    override fun parseToken(token: String): PendingUserCredentialsModel {
        val jwts: Jwt<*, *> = Jwts
            .parser()
            .build()
            .parse(token)

    }
}