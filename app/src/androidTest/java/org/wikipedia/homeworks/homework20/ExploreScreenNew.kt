package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.getName
import org.wikipedia.homeworks.tools.invokeAtIndex
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.homework07.TopReadCardViewItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.DayHeaderCardViewItem
import org.wikipedia.homeworks.homework07.AnnouncementCardViewItem
import org.wikipedia.homeworks.homework07.FeaturedArticleCardViewItem



object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Главный экран"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbarTitle: KImageView by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.setName(withParent("Заголовок"))
    }

    val searchIcon: KImageView by lazy{
        KImageView {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.setName(withParent("Значок лупы"))
    }

    val savedButton by lazy{
        KView{
            withId(R.id.nav_tab_reading_lists)
        }.setName(withParent("Кнопка списока сохраненных статей"))
    }

    val exploreButton by lazy{
        KView{
            withId(R.id.nav_tab_explore)
        }.setName(withParent("Кнопка перехода на главную страницу"))
    }


    val customizeButton: KButton by lazy{
        KButton {
            withId(R.id.view_announcement_action_positive)
        }.setName(withParent("Кнопка 'Customize'"))
    }

    val items: KRecyclerView by lazy{
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::SearchCardViewItem)
                itemType(::DayHeaderCardViewItem)
                itemType(::AnnouncementCardViewItem)
                itemType(::FeaturedArticleCardViewItem)
                itemType(::TopReadCardViewItem)
                itemType(::NewInTheNewsCardItem)
            }
        ).setName(withParent("Список блоков"))
    }

    fun newInTheNewsCardItem(index: Int, function: NewInTheNewsCardItem.() -> Unit) {
        items.invokeAtIndex(index, function)
    }

    fun newInTheNewsCardItem(): NewInTheNewsCardItem {
        return items.childWith<NewInTheNewsCardItem> {
            withDescendant {
                withText("In the news")
            }
        }.setName(items.getName().withParent("In the news"))
    }
}