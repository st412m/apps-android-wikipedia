package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.languagesList
import org.wikipedia.main.MainActivity

class ExploreTestScreen : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    private val numOfPage = 3

    @Test
    fun logoTest() {
        run {
            var page = 0
            repeat(numOfPage) {
                step("Проверяем отображение логотипа") {
                    OnboardingScreen.slider.childAt<OnboardingPagerItem>(page) {
                        wikiLogo.isDisplayed()
                    }
                }
                step("Переходим на следующую страницу") {
                    OnboardingScreen.forwardButton.click()
                }
                page++
            }
        }
    }

    @Test
    fun primaryTitleTest() {
        run {
            var page = 0
            repeat(numOfPage) {
                step("Проверяем отображение заглавного текстового поля") {
                    OnboardingScreen.slider.childAt<OnboardingPagerItem>(page) {
                        textTitle.isDisplayed()
                    }
                }
                step("Переходим на следующую страницу") {
                    OnboardingScreen.forwardButton.click()
                }
                page++
            }
        }
    }

    @Test
    fun secondaryTitleTest() {
        run {
            var page = 0
            repeat(numOfPage) {
                step("Проверяем отображение второго тестового поля") {
                    OnboardingScreen.slider.childAt<OnboardingPagerItem>(page) {
                        secondTextTitle.isDisplayed()
                    }
                }
                step("Переходим на следующую страницу") {
                    OnboardingScreen.forwardButton.click()
                }
                page++
            }
        }
    }

    @Test
    fun addLanguageButtonTest() {
        run {
            step("Проверяем отображение кнопки 'Добавить или изменить язык'") {
                OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.isDisplayed()
                }
            }
            step("Проверяем кликабельность кнопки 'Добавить или изменить язык'") {
                OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.isClickable()
                }
            }
        }
    }

    @Test
    fun bottomButtonSkipTest() {
        run {
            step("Проверяем отображение кнопки 'Skip'") {
                OnboardingScreen.skipButton.isDisplayed()
            }

            step("Проверяем кликабельность кнопки 'Skip'") {
                OnboardingScreen.skipButton.isClickable()
            }
        }
    }

    @Test
    fun pageIndicatorTest() {
        run {
            step("Наличие индикатора страниц") {
                OnboardingScreen.pageIndicator.isDisplayed()
            }
        }
    }

    @Test
    fun bottomButtonContinueTest() {
        run {
            step("Проверяем отображение кнопки 'Skip'") {
                OnboardingScreen.forwardButton.isDisplayed()
            }

            step("Проверяем кликабельность кнопки 'Skip'") {
                OnboardingScreen.forwardButton.isClickable()
            }
        }
    }

    @Test
    fun bottomButtonGetStartedTest() {
        run {
            step("Убеждаемся, что ее нет на начальном экране") {
                OnboardingScreen.doneButton.isGone()
            }

            step("Делаем 3 клика до ее появления") {
                repeat(numOfPage) {
                    OnboardingScreen.forwardButton.click()
                }
            }

            step("Проверяем отображение кнопки 'Get Started'") {
                OnboardingScreen.doneButton.isDisplayed()
            }

            step("Проверяем кликабельность кнопки 'Get Started'") {
                OnboardingScreen.doneButton.isClickable()
            }
        }
    }

    @Test
    fun addLanguageTest() {
        run {
            step("Нажимаем на кнопку 'Add or edit languge'") {
                OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.click()
                }
            }
            step("Проверяем, что открылся экран выбора языков") {
                WikipediaLanguagesScreen.toolbar.isDisplayed()
            }

            step("Проверяем наличие списка языков") {
                WikipediaLanguagesScreen.languageList.isDisplayed()
            }

            step("Проверяем наличие кнопки 'Add language'") {
                WikipediaLanguagesScreen.addLanguageButton.isDisplayed()
            }
            step("Кликаем кнопку 'Add language'") {
                WikipediaLanguagesScreen.addLanguageButton.click()
            }
            step("Проверяем, что открылся список языков") {
                AddLanguageScreen {
                    languageList.childAt<ListLanguageItem>(3) {
                        localizedLanguageName.isDisplayed()
                        languageSubtitle.isDisplayed()
                    }
                }
            }
            step("Кликаем по языку") {
                AddLanguageScreen {
                    languageList.childAt<ListLanguageItem>(3) {
                        localizedLanguageName.click()
                    }
                }
            }
            step("Кликаем верхний тулбар, чтобы вернуться на главный экран") {
                WikipediaLanguagesScreen.toolbar.click()
            }
            step("Проверяем, что язык отобразился на главном экране") {
                OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                    languages.childAt<OptionLanguageItem>(0){
                        languageName.isDisplayed()
                    }

                }
            }
        }
    }
}



