package org.wikipedia.homeworks.homework05

import androidx.appcompat.widget.AppCompatImageView
import androidx.compose.ui.test.isToggleable
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

val themeCategoryChooser = KTextView{
    withId(R.id.textSettingsCategory)
    withText(R.string.theme_category_reading)
}

val textSizePercent = KTextView{
    withId(R.id.text_size_percent)
}

val buttonDecreaseTextSize = KTextView{
    withId(R.id.buttonDecreaseTextSize)
}

val buttonIncreaseTextSize = KTextView{
    withId(R.id.buttonIncreaseTextSize)
}

val textSizeSeekBar = KSeekBar{
    withId(R.id.text_size_seek_bar)
}

val buttonFontFamilySans = KButton{
    withId(R.id.button_font_family_sans_serif)
}

val buttonFontFamilySerif = KButton{
    withId(R.id.button_font_family_serif)
}

val readingFocusModeImage = KImageView{
    withParent { isInstanceOf(AppCompatImageView::class.java) }
    withSibling { withId(R.id.theme_chooser_reading_focus_mode_switch) }
}

val themeChooserReadingFocusModeSwitch = KSwitch{
    withId(R.id.theme_chooser_reading_focus_mode_switch)
    withText(R.string.reading_focus_mode)
}

val themeChooserReadingFocusModeDescription = KTextView{
    withId(R.id.theme_chooser_reading_focus_mode_description)
    withText(R.id.theme_chooser_reading_focus_mode_description)
}

val themeChooseTextBanner = KTextView{
    withParent { isInstanceOf(MaterialTextView::class.java) }
    withText(R.string.color_theme_select)
}

val buttonThemeLight = KButton{
    withId(R.id.button_theme_light)
}

val buttonThemeSepia = KButton{
    withId(R.id.button_theme_sepia)
}

val buttonThemeDark = KButton{
    withId(R.id.button_theme_dark)
}

val buttonThemeBlack = KButton{
    withId(R.id.button_theme_black)
}

val themeChooserMatchSystemThemeSwitch = KSwitch{
    withId(R.id.theme_chooser_match_system_theme_switch)
    withText(R.string.theme_chooser_dialog_match_system_theme_switch_label)
}

val themeChooserDarkModeImagesSwitch = KSwitch{
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    withText(R.string.theme_chooser_dialog_image_dimming_switch_label)
}

fun main(){
    themeCategoryChooser.isDisplayed()

    textSizePercent.isDisplayed()
    textSizePercent.hasText("100% (Default)")

    buttonDecreaseTextSize.isDisplayed()
    buttonDecreaseTextSize.hasContentDescription("Decrease text size")

    buttonIncreaseTextSize.isDisplayed()
    buttonIncreaseTextSize.hasContentDescription("Increase text size")

    textSizeSeekBar.isDisplayed()
    textSizeSeekBar.perform {
        setProgress(0)
    }
    textSizeSeekBar.hasProgress(0)
    textSizeSeekBar.perform {
        setProgress(50)
    }
    textSizeSeekBar.hasProgress(50)
    textSizeSeekBar.perform {
        setProgress(180)
    }
    textSizeSeekBar.hasProgress(180)
    textSizeSeekBar.perform {
        setProgress(100)
    }
    textSizeSeekBar.hasProgress(100)

    buttonFontFamilySans.isDisplayed()
    buttonFontFamilySans.isActivated()
    buttonFontFamilySans.isClickable()
    buttonFontFamilySans.hasText(R.string.font_family_sans_serif)

    buttonFontFamilySerif.isDisplayed()
    buttonFontFamilySerif.isActivated()
    buttonFontFamilySerif.isClickable()
    buttonFontFamilySerif.hasText(R.string.font_family_serif)

    readingFocusModeImage.isDisplayed()

    themeChooserReadingFocusModeSwitch.isDisplayed()
    themeChooserReadingFocusModeSwitch.isActivated()
    themeChooserReadingFocusModeSwitch.hasText(R.string.reading_focus_mode)
    themeChooserReadingFocusModeSwitch.perform {
        isToggleable()
    }

    themeChooserReadingFocusModeDescription.isDisplayed()

    themeChooseTextBanner.isDisplayed()

    buttonThemeLight.isDisplayed()
    buttonThemeLight.isActivated()
    buttonThemeLight.isClickable()
    buttonThemeLight.hasText("Aa")
    buttonThemeLight.isCompletelyLeftOf {
        withId(R.id.button_theme_sepia)
    }

    buttonThemeSepia.isDisplayed()
    buttonThemeSepia.isActivated()
    buttonThemeSepia.isClickable()
    buttonThemeSepia.hasText("Aa")
    buttonThemeSepia.isCompletelyLeftOf {
        withId(R.id.button_theme_dark)
    }

    buttonThemeDark.isDisplayed()
    buttonThemeDark.isActivated()
    buttonThemeDark.isClickable()
    buttonThemeDark.hasText("Aa")
    buttonThemeLight.isCompletelyLeftOf {
        withId(R.id.button_theme_black)
    }

    buttonThemeBlack.isDisplayed()
    buttonThemeBlack.isActivated()
    buttonThemeBlack.isClickable()
    buttonThemeBlack.hasText("Aa")

    themeChooserMatchSystemThemeSwitch.isDisplayed()
    themeChooserMatchSystemThemeSwitch.isActivated()
    themeChooserMatchSystemThemeSwitch.hasText(R.string.theme_chooser_dialog_match_system_theme_switch_label)
    themeChooserMatchSystemThemeSwitch.perform {
        isToggleable()
    }

    themeChooserDarkModeImagesSwitch.isDisplayed()
    themeChooserDarkModeImagesSwitch.isActivated()
    themeChooserDarkModeImagesSwitch.hasText(R.string.theme_chooser_dialog_image_dimming_switch_label)
    themeChooserDarkModeImagesSwitch.perform {
        isToggleable()
    }
}

