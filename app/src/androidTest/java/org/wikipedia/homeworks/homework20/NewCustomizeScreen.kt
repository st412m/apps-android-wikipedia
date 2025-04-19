package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.getName
import org.wikipedia.homeworks.tools.invokeAtIndex
import org.wikipedia.homeworks.tools.setName

object NewCustomizeScreen : NamedKScreen<NewCustomizeScreen>() {
    override val screenName = "Экран кастомизации"
    override val layoutId = null
    override val viewClass = null

    val items: KRecyclerView by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.content_types_recycler)
            },
            itemTypeBuilder = {
                itemType(::NewCustomizeScreenItem)
            }
        ).setName(withParent("Список элементов"))
    }

    fun newCustomizeScreenItem(index: Int, function: NewCustomizeScreenItem.() -> Unit) {
        items.invokeAtIndex(index, function)
    }

    fun newCustomizeScreenItem(): NewCustomizeScreenItem {
        return items.childWith<NewCustomizeScreenItem> {
            withDescendant {
                withAnyText()
            }
        }.setName(items.getName().withParent("Customize the feed"))
    }
}