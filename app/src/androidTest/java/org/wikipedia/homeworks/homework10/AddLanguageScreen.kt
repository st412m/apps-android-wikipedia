package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object AddLanguageScreen : UiScreen<AddLanguageScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val languageContainer = UiScrollView {
        withId(this@AddLanguageScreen.packageName, "languages_list_recycler")
    }
    val navigateUpButton = UiButton {
        withContentDescription("Navigate up")
    }
    val addLanguageTitle = UiTextView {
        withText("Add a language")
    }
    val searchButton = UiButton {
        withId(this@AddLanguageScreen.packageName, "menu_search_language")
    }

    val languageName = UiTextView {
        withId(this@AddLanguageScreen.packageName, "localized_language_name")
    }

    val languageNameSubtitle = UiTextView {
        withId(this@AddLanguageScreen.packageName, "language_subtitle")
    }

    fun languageNameWithText(text: String) = UiTextView {
        withId(this@AddLanguageScreen.packageName, "localized_language_name")
        withText(text)
    }
}