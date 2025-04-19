package org.wikipedia.homeworks.homework20

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.tools.withParent

class NewCustomizeScreenItem(matcher: Matcher<View>) : KRecyclerItem<NewCustomizeScreenItem>(matcher) {
    val checkBox: KCheckBox by lazy {
        KCheckBox(matcher) {
            withId(R.id.feed_content_type_checkbox)
        }.setName(withParent("Чекбокс"))
    }
}
