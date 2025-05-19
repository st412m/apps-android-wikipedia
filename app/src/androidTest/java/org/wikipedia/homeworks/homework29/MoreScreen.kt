package org.wikipedia.homeworks.homework29

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.setName

object MoreScreen : NamedKScreen<MoreScreen>() {
    override val screenName = "Гамбургер"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val loginButton by lazy {
        KTextView {
            withId(R.id.main_drawer_login_button)
        }.setName(withParent("Кнопка 'Log in / join Wikipedia'"))
    }

    val settingsButton by lazy{
        KTextView {
            withId(R.id.main_drawer_settings_container)
        }.setName(withParent("Кнопка 'Settings'"))
    }

    val loginButtonImage by lazy {
        KImageView {
            withId(R.id.main_drawer_account_avatar)
        }.setName(withParent("Значок кнопки 'Log in / join Wikipedia'"))
    }
}