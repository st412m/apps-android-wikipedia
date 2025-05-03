package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.setName

object NewNewsPage : NamedKScreen <NewNewsPage>() {
    override val screenName = "Страница новости"
    override val layoutId = null
    override val viewClass = null

    val searchToolbar: KView by lazy{
        KView {
            withId(R.id.page_toolbar_button_search)
        }.setName(withParent("Поисковый тулбар"))
    }

    val saveButton by lazy{
        KView{
            withId(R.id.page_save)
        }.setName(withParent("Кнопка 'Save'"))
    }
}