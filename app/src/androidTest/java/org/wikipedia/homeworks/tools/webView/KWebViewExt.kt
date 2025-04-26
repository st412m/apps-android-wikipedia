package org.wikipedia.homeworks.tools.webView

import io.github.kakaocup.kakao.web.KWebView

fun KWebView.withXPath(xPath: String) = KWebViewElement(this, xPath)

inline fun <reified T : KWebViewItem<T>> KWebViewList.invokeAtIndex(
    targetIndex: Int,
    function: T.() -> Unit
) {
    val list: KWebViewList = this
    childAt<T>(targetIndex) {
        setName(list.getName().withParent("$targetIndex"))
        executeAction { scroll() }
        function()
    }
}