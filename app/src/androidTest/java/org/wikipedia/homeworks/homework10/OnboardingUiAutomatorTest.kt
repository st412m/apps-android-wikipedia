package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiAutomatorTest : TestCase() {

    @get:Rule

    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    private val numSwipes = 3

    @Test
    fun checkMainBlock() {
        repeat(numSwipes) {
            run {
                step("Проверяем наличие изображения") {
                    OnboardingUIScreen.image.isDisplayed()
                }
                step("Проверяем наличие заголовка") {
                    OnboardingUIScreen.primaryTitle.isDisplayed()
                }
                step("Проверям наличие описания") {
                    OnboardingUIScreen.secondaryTitle.isDisplayed()
                }
                step("Свайпаем на следующую страницу") {
                    OnboardingUIScreen.viewPager.swipeLeft()
                }
            }
        }
    }

    @Test
    fun checkLanguageBlock() {
        run {
            step("Проверяем отображение на первом экране блока языков") {
                OnboardingUIScreen.languageBlock.isEnabled()
            }
        }
    }
    @Test
    fun checkNavigationButtons(){
        repeat(numSwipes){index ->
            run {
                step("Проверяем наличие кнопки 'Skip'") {
                    OnboardingUIScreen.skipButton.isDisplayed()
                    OnboardingUIScreen.skipButton.isClickable()
                }
                step("Проверяем наличие блока отображения страницы"){
                    OnboardingUIScreen.pageIndicator.isDisplayed()

                }
            }
        }
    }
}