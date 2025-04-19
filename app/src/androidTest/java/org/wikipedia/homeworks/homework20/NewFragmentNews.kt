package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.getName
import org.wikipedia.homeworks.tools.invokeAtIndex
import org.wikipedia.homeworks.tools.setName

object NewFragmentNews : NamedKScreen<NewFragmentNews>() {
    override val screenName = "Страница карточек новостей"
    override val layoutId = null
    override val viewClass = null

    val toolbarFragmentNews : KView by lazy{
        KView{
            withId(R.id.toolbar)
        }.setName(withParent("Тулбар"))
    }

    val headerImage : KImageView by lazy{
        KImageView{
            withId(R.id.header_image_view)
        }.setName(withParent("Картинка новостной карточки"))
    }

    val storyText : KTextView by lazy{
        KTextView{
            withId(R.id.story_text_view)
        }.setName(withParent("Текст новостной карточки"))
    }

    val items: KRecyclerView by lazy{
        KRecyclerView(
            builder = {
                withId(R.id.news_story_items_recyclerview)
            },
            itemTypeBuilder = {
                itemType(::NewFragmentNewsCardItems)
            }
        ).setName(withParent("Список новостных карточек"))
    }
    fun newFragmentNewsCardItems(index: Int, function: NewFragmentNewsCardItems.() -> Unit) {
        items.invokeAtIndex(index, function)
    }

    fun newFragmentNewsCardItems(): NewFragmentNewsCardItems {
        return items.childWith<NewFragmentNewsCardItems> {
            withDescendant {
                withAnyText()
            }
        }.setName(items.getName().withParent("Список новостных карточек"))
    }
}