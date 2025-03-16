package org.wikipedia.homeworks.homework13

import android.view.View
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class PopUpWindowItems(matcher: Matcher<View>) : KViewPagerItem<PopUpWindowItems>(matcher) {

    val referenceId = KTextView {
        withId(R.id.reference_id)
    }
}