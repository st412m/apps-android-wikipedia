package org.wikipedia.homeworks.homework29

import org.wikipedia.BuildConfig

object Users {
    val alfaLogin = "alfaLogin"
    val betaLogin = "betaLogin"
    val Duhasvyacheslavych = "Duhasvyacheslavych"
}

object Credentials {
    val map = mapOf(
        Users.alfaLogin to BuildConfig.alfaLogin,
        Users.betaLogin to BuildConfig.betaLogin,
        Users.Duhasvyacheslavych to BuildConfig.Duhasvyacheslavych
    )
}