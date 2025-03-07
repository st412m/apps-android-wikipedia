package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUIScreen : UiScreen<OnboardingUIScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val viewPager = UiScrollView {
        withId(this@OnboardingUIScreen.packageName, "scrollViewContainer")
    }

    val image = UiView {
        withId(this@OnboardingUIScreen.packageName, "imageViewCentered")
    }

    val primaryTitle = UiTextView {
        withId(this@OnboardingUIScreen.packageName, "primaryTextView")
    }

    val secondaryTitle = UiTextView {
        withId(this@OnboardingUIScreen.packageName, "secondaryTextView")
    }

    val languageBlock = UiView {
        withId(this@OnboardingUIScreen.packageName, "languageListContainer")
    }

    val languageList = UiScrollView {
        withId(this@OnboardingUIScreen.packageName, "languagesList")
    }

    val languageChoice = UiTextView {
        withId(this@OnboardingUIScreen.packageName, "option_label")
    }

    val addLanguageButton = UiButton {
        withId(this@OnboardingUIScreen.packageName, "addLanguageButton")
    }

    val skipButton = UiButton {
        withId(this@OnboardingUIScreen.packageName, "fragment_onboarding_skip_button")
    }

    val pageIndicator = UiScrollView {
        withId(this@OnboardingUIScreen.packageName, "view_onboarding_page_indicator")
    }

    val pagePoint = UiView {
        withContentDescription("Page 1 of 4")
    }

    val continueButton = UiButton {
        withId(this@OnboardingUIScreen.packageName, "fragment_onboarding_forward_button")
    }

    val getStartedButton = UiButton {
        withId(this@OnboardingUIScreen.packageName, "fragment_onboarding_done_button")
    }

    fun languageItemWithText(text: String) = UiTextView {
        withId(this@OnboardingUIScreen.packageName, "option_label")
        containsText(text)
    }
}