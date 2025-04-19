package org.wikipedia.homeworks.homework22

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NewOnboardingScreen
import org.wikipedia.homeworks.tools.steps
import org.wikipedia.main.MainActivity

class BlockTest() : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        autoScrollParams = AutoScrollParams(allowedExceptions = emptySet())
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testBlocks() {
        run {
            steps {
                click(NewOnboardingScreen.skipButton)
                ExploreScreenNew.searchCardAlone {
                    isVisible()
                    voiceIcon.click()
                }
                device.uiDevice.pressBack()
                ExploreScreenNew.announcementCardAlone {
                    isVisible()
                    announcementImage.click()
                }
                ExploreScreenNew.newInTheNewsCard(2){
                    isVisible(imageMenu)
                }
                isVisible(ExploreScreenNew.getNewInTheNewsCard(1))
            }
        }
    }
}