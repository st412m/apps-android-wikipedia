package org.wikipedia.homeworks.homework24

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
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
                    .perform { newNewsCardItem(1) { click(newsCardImage) } }
                NewFragmentNews.newFragmentNewsCardItems(1) { click(newsCardItemTitle) }
                WebViewDSLPageObject {
                    waitWebView(5000)
                    scroll(referencesHeader)
                    hasText(referencesHeader, "References")
                    click(referencesHeader)

                    getReferencesList(1) {
                        containsText(content, "Rob Harris")
                    }
                    getReferencesList(2) {
                        containsText(content, "Pope Francis dies")
                    }
                }
            }
        }
    }
}


