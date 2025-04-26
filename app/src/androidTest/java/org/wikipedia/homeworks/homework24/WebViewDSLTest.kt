package org.wikipedia.homeworks.homework24

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework13.ArticleViewScreen
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NewFragmentNews
import org.wikipedia.homeworks.homework20.NewOnboardingScreen
import org.wikipedia.homeworks.tools.steps
import org.wikipedia.main.MainActivity

class WebViewDSLTest :
    TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        autoScrollParams = AutoScrollParams(allowedExceptions = emptySet())
    }
    ) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewDSLTest() {
        run {
            steps {
                click(NewOnboardingScreen.skipButton)
                ExploreScreenNew.newInTheNewsCardItem()
                    .perform { newNewsCardItem(2) { click(newsCardImage) } }
                NewFragmentNews.newFragmentNewsCardItems(1) { click(newsCardItemTitle) }
                waitWebView(10000)
                WebViewDSLPageObject {
                    scroll(referencesHeader)
                    hasText(referencesHeader, "References")
                }
            }
        }
    }
}


