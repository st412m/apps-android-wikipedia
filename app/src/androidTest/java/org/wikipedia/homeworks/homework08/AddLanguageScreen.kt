package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object AddLanguageScreen : KScreen<AddLanguageScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

     val languageList = KRecyclerView(
        builder = { withId(R.id.languages_list_recycler) },
        itemTypeBuilder = {
            itemType(::ListLanguageItem)
        }
    )
}

