package org.wikipedia.homeworks.homework23

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.tools.withParent

class WidgetWikiCardViewItem(matcher: Matcher<View>) : KRecyclerItem<WidgetWikiCardViewItem>(matcher) {
    val baseNumberView by lazy{
        KTextView(matcher) {
            withId(R.id.baseNumberView)
        }.setName(withParent("Порядковый номер"))
    }

    val cardItemTitle by lazy{
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.setName(withParent("Заголовок карточки"))
    }
    val cardItemSubtitle by lazy{
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.setName(withParent("Описание карточки"))
    }
    val cardItemGraph by lazy{
        KView(matcher) {
            withId(R.id.view_list_card_item_graph)
        }.setName(withParent("График"))
    }
    val cardItemPageViews by lazy{
        KTextView(matcher) {
            withId(R.id.view_list_card_item_pageviews)
        }.setName(withParent("Количество просмотров"))
    }
    val cardItemImage by lazy{
        KImageView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.setName(withParent("Картинка карточки"))
    }
}