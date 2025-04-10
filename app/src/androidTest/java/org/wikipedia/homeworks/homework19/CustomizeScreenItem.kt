package org.wikipedia.homeworks.homework19

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeScreenItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeScreenItem>(matcher) {
    val checkBox = KCheckBox(matcher) {
        withId(R.id.feed_content_type_checkbox)
    }
}