package org.wikipedia.homeworks.tools.webView

import androidx.test.espresso.web.webdriver.Locator
import io.github.kakaocup.kakao.web.KWebView
import io.github.kakaocup.kakao.web.WebActions
import io.github.kakaocup.kakao.web.WebAssertions
import io.github.kakaocup.kakao.web.WebElementBuilder.KWebInteraction
import org.wikipedia.homeworks.tools.NameHierarchyClass

abstract class KWebViewBaseElement<T : KWebViewBaseElement<T>>(
    val kWebView: KWebView,
    val xPath: String
) {
    abstract val self: T
    private var name: NameHierarchyClass = NameHierarchyClass("NO LABEL")

    inline fun <reified T : KWebViewBaseElement<T>> child(childXPath: String): T {
        return T::class.java
            .getConstructor(KWebView::class.java, String::class.java)
            .newInstance(kWebView, "${this.xPath}$childXPath")
    }

    operator fun invoke(function: T.() -> Unit) {
        function(self)
    }

    infix fun perform(function: T.() -> Unit): T {
        function(self)
        return self
    }

    fun executeAction(interaction: WebActions.() -> Unit) {
        kWebView {
            withElement(Locator.XPATH, xPath, interaction)
        }
    }

    fun checkAssertion(assertions: WebAssertions.() -> Unit) {
        kWebView {
            withElement(Locator.XPATH, xPath, assertions)
        }
    }

    fun setName(name: NameHierarchyClass): T {
        this.name = name
        return self
    }

    fun getName() : NameHierarchyClass = name

    fun withParent(elementName: String) = NameHierarchyClass(elementName, name)
}