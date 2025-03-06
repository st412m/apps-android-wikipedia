package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object WikipediaLanguages : UiScreen<WikipediaLanguages>() {
    override val packageName = "org.wikipedia.alpha"

    val toolbar = UiView {
        withId(this@WikipediaLanguages.packageName, "toolbar")
    }

    val navigateUpButton = UiButton {
        withContentDescription("Navigate up")
    }

    val wikiLanguageTitle = UiTextView {
        withText("Wikipedia languages")
    }

    val menuButton = UiButton {
        withContentDescription("More options")
    }

    val wikiLanguageRecycler = UiScrollView {
        withId(this@WikipediaLanguages.packageName, "wikipedia_languages_recycler")
    }

    val languageHeader = UiTextView {
        withId(this@WikipediaLanguages.packageName, "section_header_text")
    }

    val addLanguageText = UiTextView {
        withId(this@WikipediaLanguages.packageName, "wiki_language_title")
        withText("Add language")
    }

}