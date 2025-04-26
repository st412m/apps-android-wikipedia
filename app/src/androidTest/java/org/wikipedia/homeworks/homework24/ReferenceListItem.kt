package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.homeworks.tools.webView.KWebViewElement
import org.wikipedia.homeworks.tools.webView.KWebViewItem

class ReferenceListItem(kWebView: KWebView, xPath: String) :
    KWebViewItem<ReferenceListItem>(kWebView, xPath) {
    override val self: ReferenceListItem = this

    val index by lazy {
        child<KWebViewElement>("/div/div[1]")
            .setName(withParent("Индекс элемента"))
    }

    val content by lazy {
        child<KWebViewElement>("/div/div[2]/span")
            .setName(withParent("Содержимое элемента"))
    }
}