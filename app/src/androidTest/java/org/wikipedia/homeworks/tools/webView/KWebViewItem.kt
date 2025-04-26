package org.wikipedia.homeworks.tools.webView

import io.github.kakaocup.kakao.web.KWebView


abstract class KWebViewItem<T : KWebViewItem<T>>(
    kWebView: KWebView,
    xPath: String
) : KWebViewBaseElement<T>(kWebView, xPath)