package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.webView.KWebViewElement
import org.wikipedia.homeworks.tools.webView.KWebViewList
import org.wikipedia.homeworks.tools.webView.invokeAtIndex

object WebViewDSLPageObject : NamedKScreen<WebViewDSLPageObject>() {
    override val screenName: String = "WebViewDSL"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    private val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }
    val referencesHeader by lazy {
        KWebViewElement(webView, "//div[contains(@class, 'pcs-edit-section-header')]//h2[@id='References']")
            .setName(withParent("Заголовок References"))
    }

    val reference by lazy {
        KWebViewList(webView, "//ol[@class='mw-references references']").setName(withParent("Список ссылок"))
    }

    fun getReferencesList(index: Int, function: ReferenceListItem.() -> Unit) {
        reference.invokeAtIndex(index, function)
    }
}