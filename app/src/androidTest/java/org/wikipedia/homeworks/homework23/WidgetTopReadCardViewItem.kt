package org.wikipedia.homeworks.homework23

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf
import org.wikipedia.R
import org.wikipedia.homeworks.tools.KWidget
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.tools.withParent

class WidgetTopReadCardViewItem : KWidget<WidgetTopReadCardViewItem> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)

    val topReadHeaderTitle by lazy {
        KTextView(parent) {
            withId(R.id.view_card_header_title)
        }.setName(withParent("Заголовок"))
    }

    val languageCode by lazy {
        KTextView(parent) {
            withId(R.id.langCodeText)
        }.setName(withParent("Код языка"))
    }

    val imageMenu by lazy {
        KImageView(parent) {
            withId(R.id.view_list_card_header_menu)
        }.setName(withParent("Меню"))
    }

    val widgetWikiCardViewItem by lazy {
        WidgetWikiCardViewItem(
            matcher = allOf(
                isDescendantOfA(withId(R.id.view_list_card_list_container)),
                hasDescendant(withText("Sinners (2025 film)"))
            )
        ) {
        }.setName(withParent("Виджет 'Карточка в 'Top Read''"))
    }
}

