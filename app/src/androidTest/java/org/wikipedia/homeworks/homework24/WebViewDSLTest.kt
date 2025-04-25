package org.wikipedia.homeworks.homework24

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework13.ArticleViewScreen
import org.wikipedia.homeworks.tools.steps
import org.wikipedia.main.MainActivity

class WebViewDSLTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewDSLTest() {
        run {
            OnboardingScreen.skipButton.click()
            ExploreScreen.items.childWith<SearchCardViewItem> {
                withDescendant {
                    withText("Featured article")
                }
            }.perform {
                click()
            }
        }

        ArticleViewScreen {
            WebViewDSLPageObject.reference.executeAction {
                scroll()
            }
        }
    }
}
