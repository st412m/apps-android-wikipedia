package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object WikipediaLanguagesScreen : KScreen<WikipediaLanguagesScreen>() {

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbar = KToolbar{ withId(R.id.toolbar) }

    val languageList = KRecyclerView({
        withId(R.id.wikipedia_languages_recycler)
    }, itemTypeBuilder = {
        itemType(::LanguageItem)
    })

    val addLanguageButton = KButton { withText("Add language") }
}