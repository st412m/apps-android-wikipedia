package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.homeworks.homework07.AnnouncementCardViewItem
import org.wikipedia.homeworks.homework07.DayHeaderCardViewItem
import org.wikipedia.homeworks.homework07.FeaturedArticleCardViewItem
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadCardViewItem


object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Главный экран"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbarTitle: KImageView by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }
            .setName(withParent("Заголовок"))
    }


    val customizeButton = KButton {
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
    ).setName(withParent("Список блоков"))

    fun topReadCardViewItem(index: Int, function: TopReadCardViewItem.() -> Unit) {
        items.invokeAtIndex(index, function)
    }


    fun topReadCardViewItem(): TopReadCardViewItem {
        return items.childWith<TopReadCardViewItem> {
            withDescendant {
                withText("Top read")
            }
        }.setName(items.getName().withParent("Top read"))
    }
}