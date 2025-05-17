package org.wikipedia.homeworks.homework29

import androidx.test.platform.app.InstrumentationRegistry
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.setName

object LoginScreen : NamedKScreen<LoginScreen>() {
    override val screenName = "Экран логина"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    private fun getStringResource(resourceId: Int): String {
        return context.getString(resourceId)
    }

    val usernameField by lazy {
        KEditText {
            isInstanceOf(org.wikipedia.views.PlainPasteEditText::class.java)
            withHint(this@LoginScreen.getStringResource(R.string.login_username_hint))
        }.setName(withParent("Поле ввода имени пользователя"))
    }

    val passwordField by lazy {
        KEditText {
            isInstanceOf(org.wikipedia.views.PlainPasteEditText::class.java)
            withHint(this@LoginScreen.getStringResource(R.string.login_password_hint))
        }.setName(withParent("Поле ввода пароля"))
    }

    val loginButton by lazy {
        KButton {
            withId(R.id.login_button)
        }.setName(withParent("Кнопка 'Log in'"))
    }
}