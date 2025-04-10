package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

object CustomizeScreen : KScreen<CustomizeScreen>() {
    override val layoutId = null
    override val viewClass = null

     val customizeScreenRecycler = KRecyclerView(
        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
            itemType(::CustomizeScreenItem)
        }
    )
}