package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework07.NewsCardItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework21.CustomViewAction
import org.wikipedia.homeworks.homework21.CustomViewAssertion
import org.wikipedia.homeworks.homework21.customCheckText
import org.wikipedia.homeworks.homework21.customClick
import org.wikipedia.homeworks.homework21.getText
import org.wikipedia.main.MainActivity

class InTheNewsTestScreen : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun inTheNewsTest() {
        run {
            step("Покидаем onboarding") {
 //               OnboardingScreen.skipButton.view.check(CustomViewAssertion("Skip")) // кастомная проверка
                OnboardingScreen.skipButton.customCheckText("Skip")
 //               OnboardingScreen.skipButton.view.perform(CustomViewAction())  // кастомный клик
                val text = OnboardingScreen.skipButton.getText()
                Assert.assertEquals("Skip", text)
                OnboardingScreen.skipButton.customClick()
            }
            step("Проверяем есть ли у нас блок 'In the news'") {
                ExploreScreen.items.childWith<InTheNewsCardItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    inTheNewsHeaderTitle.hasAnyText()
                }
            }
            step("Листаем до третьей картинки и кликаем на неё") {
                ExploreScreen.items.childWith<InTheNewsCardItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    newsCardReaderItems.childAt<NewsCardItem>(2) {
                        newsCardImage.click()
                    }
                }
            }
            step("Кликаем по второй статье из списка") {
                FragmentNews.newsStoryItemsRecycler.childAt<NewsCardItems>(1) {
                    newsCardItemTitle.click()
                }
            }
            step("Проверяем, что отображается элемент с ID page_web_view") {
                NewsPage.newsPageWebView.isDisplayed()
            }
        }
    }
}


