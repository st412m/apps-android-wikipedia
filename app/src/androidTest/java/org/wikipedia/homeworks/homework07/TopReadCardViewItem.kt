package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadCardViewItem(matcher: Matcher<View>) : KRecyclerItem<TopReadCardViewItem>(matcher) {
    val topReadHeaderTitle = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }
    val languageCode = KTextView(matcher) {
        withId(R.id.langCodeText)
    }
    val imageMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val wikiCardViewItems = KRecyclerView(
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::WikiCardViewItem)
        }
    )
}