package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OptionLanguageItem(parent: Matcher<View>) : KRecyclerItem<OptionLanguageItem>(parent) {
    val languageName = KView(parent) { withId(R.id.option_label) }
}