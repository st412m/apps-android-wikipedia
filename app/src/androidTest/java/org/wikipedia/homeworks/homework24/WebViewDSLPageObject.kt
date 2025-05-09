package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.NewNewsPage
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.tools.webView.KWebViewElement
import org.wikipedia.homeworks.tools.webView.KWebViewList
import org.wikipedia.homeworks.tools.webView.invokeAtIndex

object WebViewDSLPageObject : NamedKScreen<WebViewDSLPageObject>() {
    override val screenName: String = "Вебстраница"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    private val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }
    val referencesHeader by lazy {
        KWebViewElement(webView, "//div[contains(@class, 'pcs-edit-section-header')]//h2[@id='References']")
            .setName(withParent("Заголовок"))
    }

    val mainImage by lazy{
        KView{
            withId(R.id.view_page_header_image)
        }.setName(withParent("Изображение"))
    }

    val articleImage by lazy {
        KWebViewElement(WebViewDSLPageObject.webView, "//figure[@class='infobox-image']//img")
            .setName(NewNewsPage.withParent("Верхнее изображение"))
    }

    val saveButton by lazy {
        KView {
            withId(R.id.page_save)
        }.setName(NewNewsPage.withParent("Кнопка 'Save'"))
    }

    val reference by lazy {
        KWebViewList(webView, "//ol[@class='mw-references references']")
            .setName(withParent("Список ссылок"))

    }

    fun getReferencesList(index: Int, function: ReferenceListItem.() -> Unit) {
        reference.invokeAtIndex(index, function)
    }

}