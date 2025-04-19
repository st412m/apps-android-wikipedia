package org.wikipedia.homeworks.homework07

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView


object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val toolbarTitle = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val customizeButton = KButton{
        withId(R.id.view_announcement_action_positive)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchCardViewItem)
            itemType(::DayHeaderCardViewItem)
            itemType(::AnnouncementCardViewItem)
            itemType(::FeaturedArticleCardViewItem)
            itemType(::TopReadCardViewItem)
            itemType(::InTheNewsCardItem)
        }
    )
}