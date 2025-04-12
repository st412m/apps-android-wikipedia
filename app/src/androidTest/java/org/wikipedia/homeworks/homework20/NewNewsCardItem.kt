package org.wikipedia.homeworks.homework20

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.namedElements.setName
import org.wikipedia.homeworks.namedElements.withParent

class NewNewsCardItem(matcher: Matcher<View>) : KRecyclerItem<NewNewsCardItem>(matcher) {
    val newsCardImage: KImageView by lazy {
        KImageView(matcher) {
            withId(R.id.horizontal_scroll_list_item_image)
        }.setName(withParent("Картинка новостной карточки"))
    }

    val newsCardText: KTextView by lazy {
        KTextView(matcher) {
            withId(R.id.horizontal_scroll_list_item_text)
        }.setName(withParent("Текст новостной карточки"))
    }
}