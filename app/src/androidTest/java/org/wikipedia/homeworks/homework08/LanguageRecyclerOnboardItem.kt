package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

object LanguageRecyclerOnboardItem : KScreen<LanguageRecyclerOnboardItem>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val languages = KRecyclerView(
        builder = {
            withId(R.id.languagesList)
        },
        itemTypeBuilder = {
            itemType(::OptionLanguageItem)
        }
    )


}