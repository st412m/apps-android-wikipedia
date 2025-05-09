package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.tools.webView.KWebViewElement

object NewNewsPage : NamedKScreen<NewNewsPage>() {
    override val screenName = "Страница новости"
    override val layoutId = null
    override val viewClass: Class<*>? = null

    private val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    val searchToolbar: KView by lazy {
        KView {
            withId(R.id.page_toolbar_button_search)
        }.setName(withParent("Поисковый тулбар"))
    }

    val articleImage by lazy {
        KWebViewElement(webView, "//figure[@class='mw-default-size mw-halign-right mcs-niden-image-ancestor']//img")
            .setName(NewNewsPage.withParent("Верхнее изображение"))
    }

    val saveButton by lazy {
        KView {
            withId(R.id.page_save)
        }.setName(withParent("Кнопка 'Save'"))
    }
}
