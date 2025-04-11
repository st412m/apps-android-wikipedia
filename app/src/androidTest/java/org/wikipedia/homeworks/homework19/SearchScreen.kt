package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import androidx.appcompat.R

object SearchScreen : KScreen<SearchScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchField = KEditText {
        withId(R.id.search_src_text)
//        withResourceName("search_src_text")
    }
}