package org.wikipedia.homeworks.homework20

import androidx.appcompat.R
import io.github.kakaocup.kakao.edit.KEditText
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.setName

object NewSearchScreen : NamedKScreen<NewSearchScreen>() {
    override val screenName = "Экран поиска"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchField by lazy {
        KEditText {
            withId(R.id.search_src_text)
        }.setName(withParent("Поле поиска"))
    }
}