package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NewInTheNewsCardItem
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.getName
import org.wikipedia.homeworks.tools.invokeAtIndex
import org.wikipedia.homeworks.tools.setName

object ExploreScreenForWebView : NamedKScreen<ExploreScreenForWebView>() {
    override val screenName = "Главный экран"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbarTitle: KImageView by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.setName(ExploreScreenNew.withParent("Заголовок"))
    }

    val searchIcon: KImageView by lazy{
        KImageView {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.setName(ExploreScreenNew.withParent("Значок лупы"))
    }


    val customizeButton: KButton by lazy{
        KButton {
            withId(R.id.view_announcement_action_positive)
        }.setName(ExploreScreenNew.withParent("Кнопка 'Customize'"))
    }

    val items: KRecyclerView by lazy{
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::NewInTheNewsCardItem)
            }
        ).setName(ExploreScreenNew.withParent("Список блоков"))
    }

    fun newInTheNewsCardItem(index: Int, function: NewInTheNewsCardItem.() -> Unit) {
        ExploreScreenNew.items.invokeAtIndex(index, function)
    }

    fun newInTheNewsCardItem(): NewInTheNewsCardItem {
        return ExploreScreenNew.items.childWith<NewInTheNewsCardItem> {
            withDescendant {
                withText("In the news")
            }
        }.setName(ExploreScreenNew.items.getName().withParent("In the news"))
    }
}