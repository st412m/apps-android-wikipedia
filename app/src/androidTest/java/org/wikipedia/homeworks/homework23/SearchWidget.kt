package org.wikipedia.homeworks.homework23

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.compose.ui.test.hasContentDescription
import androidx.test.platform.app.InstrumentationRegistry
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.tools.KWidget
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.tools.withParent

class SearchWidget : KWidget<SearchWidget> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    private fun getStringResource(resourceId: Int): String {
        return context.getString(resourceId)
    }


    val searchIcon by lazy{
        KImageView(parent) {
            hasContentDescription(this@SearchWidget.getStringResource(R.string.search_hint))
            isInstanceOf(AppCompatImageView::class.java)
        }.setName(withParent("Значок поиска"))
    }
    val searchText by lazy{
        KTextView(parent) {
            withText(this@SearchWidget.getStringResource(R.string.search_hint))
        }.setName(withParent("Текстовое поле"))
    }

    val voiceIcon by lazy{
        KImageView(parent) {
            withId(R.id.voice_search_button)
        }.setName(withParent("Значок голосового поиска"))
    }
}