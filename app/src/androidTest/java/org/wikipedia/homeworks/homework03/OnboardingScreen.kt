package org.wikipedia.homeworks.homework03

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)

val addOrEditLanguages = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

val pageIndicator = listOf(
    TabLayout::class.java,
    "view_onboarding_page_indicator"
)

val languagesList = listOf(
    RecyclerView::class.java,
    "languagesList",
    listOf(
        AppTextView::class.java,
        "option_label"
    ),
    listOf(
        AppTextView::class.java,
        "option_label"
    )
)

val firstLineText = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "Lorem ipsum"
)

val secondLineText = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
)

val mainImage = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered",
    "illustration_onboarding_explore"
)

// after pressing continue

val mainImagePageTwo = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered",
    "illustration_onboarding_explore"
)

val firstLineTextPageTwo = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "Lorem ipsum"
)

val secondLineTextPageTwo = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
)