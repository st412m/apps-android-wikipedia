package org.wikipedia.homeworks.homework29

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NewOnboardingScreen
import org.wikipedia.homeworks.tools.interceptors.FailOnlyScreenshotStepInterceptor
import org.wikipedia.homeworks.tools.interceptors.SuccessFinaleScreenshotTestInterceptor
import org.wikipedia.homeworks.tools.steps
import org.wikipedia.main.MainActivity

class LoginTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        stepWatcherInterceptors.removeIf {
            it is ScreenshotStepInterceptor
        }
        testRunWatcherInterceptors.add(SuccessFinaleScreenshotTestInterceptor(screenshots))
        stepWatcherInterceptors.add(FailOnlyScreenshotStepInterceptor(screenshots))
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loginTest() {
        run {
            steps {
                NewOnboardingScreen {
                    click(skipButton)
                }
                uiClick("Allow")
                authorization("Duhasvyacheslavych")
                ExploreScreenNew {
                    click(moreButton)
                }
                sleep(10000)
            }
        }
    }
}