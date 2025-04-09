package org.wikipedia.homeworks.homework19

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsCardItemsWithCompactSteps(matcher: Matcher<View>) : KRecyclerItem<NewsCardItemsWithCompactSteps>(matcher) {

    val newsCardNumber = KView(matcher){
        withId(R.id.view_list_card_number)
    }

    val newsCardItemTitle = KTextView(matcher){
        withId(R.id.view_list_card_item_title)
    }

    val newsCardItemSubtitle = KTextView(matcher){
        withId(R.id.view_list_card_item_subtitle)
    }

    val newsCardItemGraph = KView(matcher){
        withId(R.id.view_list_card_item_graph)
    }

    val newsCardItemPageViews = KTextView(matcher){
        withId(R.id.view_list_card_item_pageviews)
    }

    val newsCardItemImage = KImageView(matcher){
        withId(R.id.view_list_card_item_image)
    }
}