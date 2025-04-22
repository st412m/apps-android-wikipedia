package org.wikipedia.homeworks.homework23

import android.view.View
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

    val searchIcon by lazy{
        KImageView(parent) {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.setName(withParent("Значок поиска"))
    }
    val searchText by lazy{
        KTextView(parent) {
            withText(R.string.search_hint)
        }.setName(withParent("Текстовое поле"))
    }

    val voiceIcon by lazy{
        KImageView(parent) {
            withId(R.id.voice_search_button)
        }.setName(withParent("Значок голосового поиска"))
    }
}