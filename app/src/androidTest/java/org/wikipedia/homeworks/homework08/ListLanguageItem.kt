package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ListLanguageItem (parent: Matcher<View>) : KRecyclerItem<LanguageItem>(parent) {
    val localizedLanguageName = KTextView(parent) {
        withId(R.id.localized_language_name)
    }
    val languageSubtitle = KTextView(parent) {
        withId(R.id.language_subtitle)
    }
}