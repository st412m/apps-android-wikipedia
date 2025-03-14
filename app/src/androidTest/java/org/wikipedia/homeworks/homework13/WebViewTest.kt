package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest(){
        run{
            OnboardingScreen.skipButton.click()
            ExploreScreen.items.childWith<SearchCardViewItem> {
                withDescendant {
                    withText("Featured article")
                }
            }.perform {
                click()
            }
        }
        ArticleViewScreen{
            webView{
                withElement(Locator.XPATH,"//span[@class='mw-page-title-main']"){
                    this.containsText("Five pounds")
                }
            }
        }
    }
}