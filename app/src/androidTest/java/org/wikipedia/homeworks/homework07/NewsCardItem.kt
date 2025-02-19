package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsCardItem(matcher: Matcher<View>) : KRecyclerItem<NewsCardItem>(matcher) {
    val newsCardImage = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }
    val newsCardText = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }
}