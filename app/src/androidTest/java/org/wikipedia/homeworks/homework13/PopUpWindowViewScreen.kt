package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import org.wikipedia.R

object PopUpWindowViewScreen : KScreen<PopUpWindowViewScreen>() {
    override val layoutId = null
    override val viewClass = null


    val pager = KViewPager2(
        builder = {
            withId(R.id.reference_pager)
        },
        itemTypeBuilder = {
            itemType(::PopUpWindowItems)
        }
    )
}