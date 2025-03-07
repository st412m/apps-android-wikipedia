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
    private val selectedLanguage = "Français"

    @Test
    fun checkMainBlock() {
        repeat(numSwipes) { index ->
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
                OnboardingUIScreen.languageBlock.isDisplayed()
            }
        }
    }

    @Test
    fun checkNavigationButtons() {
        repeat(numSwipes) { index ->
            run {
                step("Проверяем наличие кнопки 'Skip'") {
                    OnboardingUIScreen.skipButton.isDisplayed()
                    OnboardingUIScreen.skipButton.isClickable()
                }
                step("Проверяем наличие блока отображения страницы") {
                    OnboardingUIScreen.pageIndicator.isDisplayed()

                }
                step(
                    "Проверяем наличие кнопки 'Contunue' на всех экранах кроме " +
                            "последнего"
                ) {
                    if (index <= 2) {
                        OnboardingUIScreen.continueButton.isDisplayed()
                        OnboardingUIScreen.continueButton.isClickable()
                    } else {
                        OnboardingUIScreen.continueButton.isNotDisplayed()
                    }
                }
                step(
                    "Проверяем отсутствие кнопки 'Get Started' на всех экранах кроме " +
                            "последнего"
                ) {
                    if (index <= 2) {
                        OnboardingUIScreen.getStartedButton.isNotDisplayed()

                    } else {
                        OnboardingUIScreen.getStartedButton.isDisplayed()
                        OnboardingUIScreen.getStartedButton.isClickable()
                    }
                }
                step("Свайпаем на следующую страницу") {
                    OnboardingUIScreen.viewPager.swipeLeft()
                }
            }
        }
    }

    @Test
    fun addLanguageTest() {
        run {
            step("Кликаем кнопку 'Add or edit language' на главном экране") {
                OnboardingUIScreen.addLanguageButton.click()
            }
            step("Кликаем кнопку 'Add language' на экране Wikipedia Languges") {
                WikipediaLanguages.addLanguageText.click()
            }
            step(
                "Выбираем язык 'Deutsch' - определяется в переменной selectedLanguage в " +
                        "OnboardingUIScreen"
            ) {
                AddLanguageScreen.languageContainer.scrollToStart()
                val langName =
                    AddLanguageScreen.languageNameWithText(selectedLanguage)
                    AddLanguageScreen.languageContainer.scrollToView(langName)
                    langName.click()
            }
            step("Возвращаемся на главную страницу") {
                WikipediaLanguages.navigateUpButton.click()
            }
            step("Проверяем наличие соответствующего языка на главной странице") {
                val langItem =
                    OnboardingUIScreen.languageItemWithText(selectedLanguage)
                OnboardingUIScreen.languageList.scrollToView(langItem)
                langItem.isDisplayed()
                langItem.containsText(selectedLanguage)
            }
        }
    }
}
