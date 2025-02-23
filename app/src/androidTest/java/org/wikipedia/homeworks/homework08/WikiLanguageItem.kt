package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class WikiLanguageItem(matcher: Matcher<View>) : KRecyclerItem<WikiLanguageItem>(matcher) {
    val addLanguageButton = KTextView(matcher) {
        withId(R.id.wiki_language_title)
    }

}