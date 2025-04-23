package org.wikipedia.homeworks.homework23

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.NewOnboardingScreen
import org.wikipedia.homeworks.tools.steps
import org.wikipedia.main.MainActivity

class WidgetTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWithWidget() {
        run {
            steps{
                click(NewOnboardingScreen.skipButton)
                ExploreScreenWithWidget.searchWidget{
                    isVisible(searchText)
                    isVisible(voiceIcon)
                }
                device.uiDevice.swipe(
                    device.uiDevice.displayWidth / 2,
                    device.uiDevice.displayHeight * 2 / 3,
                    device.uiDevice.displayWidth / 2,
                    device.uiDevice.displayHeight / 4,
                    10
                )
                    Thread.sleep(500)

                ExploreScreenWithWidget.topReadWidget{
                    isDisplayed(topReadHeaderTitle)
                    isDisplayed(languageCode)
                    isDisplayed(imageMenu)
                }
                ExploreScreenWithWidget.topReadWidget.widgetWikiCardViewItem{
                    isDisplayed(baseNumberView)
                    isDisplayed(cardItemTitle)
                    isDisplayed(cardItemSubtitle)
                    isDisplayed(cardItemGraph)
                    isDisplayed(cardItemPageViews)
                    isDisplayed(cardItemImage)
                }
            }
        }
    }
}