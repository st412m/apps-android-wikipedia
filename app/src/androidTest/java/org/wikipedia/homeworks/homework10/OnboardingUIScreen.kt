package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUIScreen : UiScreen<OnboardingUIScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val image = UiView{
        withId(this@OnboardingUIScreen.packageName,"imageViewCentered")
    }
}