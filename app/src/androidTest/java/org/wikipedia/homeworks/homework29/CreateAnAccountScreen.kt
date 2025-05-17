package org.wikipedia.homeworks.homework29

import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.setName

object CreateAnAccountScreen : NamedKScreen<CreateAnAccountScreen>() {
    override val screenName = "Экран создания аккаунта"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val loginButton by lazy {
        KButton {
            withId(R.id.create_account_login_button)
        }.setName(withParent("Кнопка 'Log in'"))
    }
}