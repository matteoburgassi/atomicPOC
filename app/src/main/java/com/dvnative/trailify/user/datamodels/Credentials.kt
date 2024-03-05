package com.dvnative.trailify.user.datamodels

import kotlinx.serialization.Serializable
import java.security.MessageDigest

@Serializable
sealed class Credentials {
    @Serializable
    class Username(
        val value: String,
        val password: String
    ): Credentials()
}

val String.dvHash: Any
    get() {
        val baseSalt = "AN65Bef2sW6n"
        val baseSaltSha1 = MessageDigest.getInstance("SHA-1").digest(baseSalt.toByteArray()).toHex()
        val salt = MessageDigest.getInstance("md5").digest(baseSaltSha1.toByteArray().copyOfRange(3,27)).toHex()
        return MessageDigest.getInstance("SHA-1").digest(salt.toByteArray().copyOfRange(0,10) + toByteArray() + salt.toByteArray().copyOfRange(10,32)).toHex()
    }

fun ByteArray.toHex(): String = joinToString(separator = "") { eachByte -> "%02x".format(eachByte) }