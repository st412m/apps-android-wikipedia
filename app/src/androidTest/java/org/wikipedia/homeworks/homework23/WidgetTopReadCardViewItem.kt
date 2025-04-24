package org.wikipedia.homeworks.homework23

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.tools.KWidget
import org.wikipedia.homeworks.tools.invokeAtIndex
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

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::WidgetWikiCardViewItem)
            }
        ).setName(withParent("Карточка в виджете 'Top Read'"))
    }
    fun topReadWidgetItems(index: Int, function: WidgetWikiCardViewItem.() -> Unit) {
        items.invokeAtIndex(index, function)
    }
}

