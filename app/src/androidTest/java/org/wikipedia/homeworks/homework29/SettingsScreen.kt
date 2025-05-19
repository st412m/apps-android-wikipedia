package org.wikipedia.homeworks.homework29

import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.R

object SettingsScreen: NamedKScreen<SettingsScreen>() {
    override val screenName = "Настройки"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val logoutButton by lazy{
        KButton{
            withId(R.id.logoutButton)
        }
    }
}