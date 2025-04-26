package org.wikipedia.homeworks.tools.webView

import io.github.kakaocup.kakao.web.KWebView


class KWebViewElement(kWebView: KWebView, xPath: String) :
    KWebViewBaseElement<KWebViewElement>(kWebView, xPath) {
    override val self: KWebViewElement = this
}