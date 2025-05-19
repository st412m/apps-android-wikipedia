package org.wikipedia.homeworks.homework27

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NewFragmentNews
import org.wikipedia.homeworks.homework20.NewNewsPage
import org.wikipedia.homeworks.homework20.NewOnboardingScreen
import org.wikipedia.homeworks.tools.interceptors.SuccessFinaleScreenshotTestInterceptor
import org.wikipedia.homeworks.tools.steps
import org.wikipedia.main.MainActivity

class AllureSupportSuccessTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        stepWatcherInterceptors.removeIf {
            it is ScreenshotStepInterceptor
        }
        testRunWatcherInterceptors.add(SuccessFinaleScreenshotTestInterceptor(screenshots))
    }
){
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun smartScenarioSuccessTest() {
        run {
            steps {
                NewOnboardingScreen {
                    click(skipButton)
                }
                ExploreScreenNew.newInTheNewsCardItem()
                    .perform { newNewsCardItem(1) { click(newsCardImage) } }
                NewFragmentNews.newFragmentNewsCardItems(0) {
                    click(newsCardItemTitle)
                }
                NewNewsPage{
                    click(saveButton)
                }

                repeat(2){
                    waitForIdle(500)
                    pressBack()
                }

                ExploreScreenNew{
                    click(savedButton)
                    click(exploreButton)
                }
            }
        }
    }
}




