package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.namedElements.NamedKScreen
import org.wikipedia.homeworks.namedElements.getName
import org.wikipedia.homeworks.namedElements.invokeAtIndex
import org.wikipedia.homeworks.namedElements.setName

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