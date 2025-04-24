package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.tools.withParent

class AnnouncementCardViewItem(matcher: Matcher<View>) :
    KRecyclerItem<AnnouncementCardViewItem>(matcher) {

    val announcementImage = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }
    val announcementText by lazy{
        KTextView(matcher) {
            withId(R.id.view_announcement_text)
        }.setName(withParent("Текст анонса"))
    }
    val announcementCustomizeButton = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
    }
    val announcementGotItButton = KButton(matcher) {
        withId(R.id.view_announcement_action_negative)
    }
}