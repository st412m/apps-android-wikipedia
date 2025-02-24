package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguageItem(parent: Matcher<View>) : KRecyclerItem<LanguageItem>(parent) {
    val order = KTextView(parent) { withId(R.id.wiki_language_order) }
    val langCode = KTextView(parent) { withId(R.id.wiki_language_code) }
    val title = KTextView(parent) { withId(R.id.wiki_language_title) }
    val dragHandle = KView(parent) { withId(R.id.wiki_language_drag_handle) }
}