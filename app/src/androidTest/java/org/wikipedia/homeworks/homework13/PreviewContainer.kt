package org.wikipedia.homeworks.homework13

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

object PreviewContainer : UiScreen<PreviewContainer>() {
    override val packageName = "org.wikipedia.alpha"

    val readArticleButton = UiButton {
        withId(this@PreviewContainer.packageName, "link_preview_primary_button")
    }
}
