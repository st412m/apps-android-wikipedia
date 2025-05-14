package org.wikipedia.homeworks.homework28

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
import org.wikipedia.homeworks.tools.allureinterceptors.FailOnlyScreenshotStepInterceptor
import org.wikipedia.homeworks.tools.allureinterceptors.SuccessFinaleScreenshotTestInterceptor
import org.wikipedia.homeworks.tools.rules.DeprecatedTestRule
import org.wikipedia.homeworks.tools.steps
import org.wikipedia.main.MainActivity

class DeprecatedTest: TestCase(
kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
    stepWatcherInterceptors.removeIf {
        it is ScreenshotStepInterceptor
    }
    testRunWatcherInterceptors.add(SuccessFinaleScreenshotTestInterceptor(screenshots))
    stepWatcherInterceptors.add(FailOnlyScreenshotStepInterceptor(screenshots))

}
){
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get: Rule
    val deprecatedTestRule = DeprecatedTestRule()


    @Test
    @Deprecated("Пустой тест раз")
    fun testForDeprecateOne(){}

    @Test
    fun smartScenarioErrorAndDeprecatedTest() {
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
                    swipeVertically(0.5,10, false)
                    waitForIdle(5000)
                    click(exploreButton)
                }
            }
        }
    }

    @Test
    @Deprecated("Пустой тест два")
    fun testForDeprecateTwo(){}

    @Test
    fun smartScenarioSuccessAndDeprecatedTest() {
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

    @Test
    @Deprecated("Пустой тест три")
    fun testForDeprecateThree(){}
}