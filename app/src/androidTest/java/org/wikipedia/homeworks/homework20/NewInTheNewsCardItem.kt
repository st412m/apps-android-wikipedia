package org.wikipedia.homeworks.homework20

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.tools.getName
import org.wikipedia.homeworks.tools.invokeAtIndex
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.tools.withParent

class NewInTheNewsCardItem(matcher: Matcher<View>) : KRecyclerItem<NewInTheNewsCardItem>(matcher) {
    val inTheNewsHeaderTitle: KTextView by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.setName(withParent("Заголовок новостной карточки"))
    }

    val languageCode: KTextView by lazy {
        KTextView(matcher) {
            withId(R.id.langCodeText)
        }.setName(withParent("Код языка"))
    }

    val imageMenu: KImageView by lazy{
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.setName(withParent("Картинка карточки новостей"))
    }

    val items: KRecyclerView by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.news_cardview_recycler_view)
            },
            itemTypeBuilder = {
                itemType(::NewNewsCardItem)
            }
        ).setName(withParent("Список новостных карточек"))
    }

    fun newNewsCardItem(index: Int, function: NewNewsCardItem.() -> Unit) {
        items.invokeAtIndex(index, function)
    }

    fun newNewsCardItem(): NewNewsCardItem {
        return items.childWith<NewNewsCardItem> {
            withDescendant {
                withAnyText()
            }
        }.setName(items.getName().withParent("Новость"))
    }
}