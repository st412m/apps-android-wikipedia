package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class ExploreTestScreen : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    private val numOfPage = 3

    @Test
    fun logoTest() {
        run {
            repeat(numOfPage) {
                step("Проверяем отображение логотипа") {
                    OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                        wikiLogo.isDisplayed()
                    }
                }
                step("Переходим на следующую страницу") {
                    OnboardingScreen.forwardButton.click()
                }
            }
        }
    }

    @Test
    fun primaryTitleTest() {
        run {
            repeat(numOfPage) {
                step("Проверяем отображение заглавного текстового поля") {
                    OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                        textTitle.isDisplayed()
                    }
                }
                step("Переходим на следующую страницу") {
                    OnboardingScreen.forwardButton.click()
                }
            }
        }
    }

    @Test
    fun secondaryTitleTest() {
        run {
            repeat(numOfPage) {
                step("Проверяем отображение второго тестового поля") {
                    OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                        foundLanguageText.isDisplayed()
                    }
                }
            }
            step("Переходим на следующую страницу") {
                OnboardingScreen.forwardButton.click()
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
    fun bottomButtonSkip() {
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
    fun pageIndicator() {
        run {
            step("Наличие индикатора страниц") {
                OnboardingScreen.pageIndicator.isDisplayed()
            }
        }
    }

    @Test
    fun bottomButtonContinue() {
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
    fun bottomButtonGetStarted() {
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
}