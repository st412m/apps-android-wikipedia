package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.views.GraphView

class WikiCardViewItem(matcher: Matcher<View>) : KRecyclerItem<WikiCardViewItem>(matcher) {
    val baseNumberView = KTextView(matcher) {
        withId(R.id.baseNumberView)
    }
    val circleNum = KImageView(matcher) {
        withDrawable(R.drawable.shape_circle)
    }
    val numberView = KTextView(matcher) {
        withId(R.id.numberView)
    }
    val cardItemTitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }
    val cardItemSubtitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }
    val cardItemGraph = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }
    val cardItemPageViews = KTextView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }
    val cardItemImage = KImageView(matcher) {
        withId(R.id.view_list_card_item_image)
    }
}