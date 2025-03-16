package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.TopReadCardViewItem
import org.wikipedia.homeworks.homework07.WikiCardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class TopReadWebViewTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple {
        autoScrollParams = AutoScrollParams(allowedExceptions = emptySet())
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun topReadTest() {
        run {
            step("Покидаем онбоардинг") {
                OnboardingScreen.skipButton.click()
            }
            step("Кликаем на 2 статью в блоке 'Top read'") {
                ExploreScreen.items.childWith<TopReadCardViewItem> {
                    withDescendant {
                        withText("Top read")
                    }
                }.perform {
                    wikiCardViewItems.childAt<WikiCardViewItem>(1) {
                        cardItemTitle.click()
                    }
                }
            }
            step("Скроллим до элемента с id 'References' и проверяем его содержимое по тексту") {
                ArticleViewScreen {
                    webView {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                        }
                    }
                }
            }
            step(
                "Жмакаем на ссылку в тексте с номером 5"
            ) {
                ArticleViewScreen {
                    webView {
                        withElement(
                            Locator.XPATH,
                            "//a[@class='reference-link' and .//text()='5']"
                        ) {
                            scroll()
                            click()
                        }
                    }
                }
            }
            step("Проверяем на соответствие текст заголовка и номер в строке во всплывающем окне") {
                PopUpWindowViewScreen.pager.childAt<PopUpWindowItems>(0) {
                    referenceId.isVisible()
                    referenceId.containsText("5")
                }
            }
            step("Закрываем всплывающее окно") {
                device.uiDevice.pressBack()
            }
            step("Открываем вторую ссылку с CSS классом mw-redirect и нажать на неё") {
                ArticleViewScreen {
                    webView {
                        withElement(
                            Locator.CSS_SELECTOR, "a.mw-redirect:nth-child(4)"
                        ) {
                            scroll()
                            click()
                        }
                    }
                }
            }
            step("Клипаем кнопу 'Read article'") {
                flakySafely(timeoutMs = 10000) {
                    PreviewContainer.readArticleButton.click()
                }
            }
            step("Скроллим до элемента с id 'References'") {
                ArticleViewScreen {
                    webView {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                        }
                    }
                }
            }
        }
    }
}

