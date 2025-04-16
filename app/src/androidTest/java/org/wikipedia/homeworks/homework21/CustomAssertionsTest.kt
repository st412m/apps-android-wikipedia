package org.wikipedia.homeworks.homework21

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NewCustomizeScreen
import org.wikipedia.homeworks.homework20.NewOnboardingScreen
import org.wikipedia.homeworks.namedElements.steps
import org.wikipedia.main.MainActivity

class CustomAssertionsTest : TestCase(
kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
    autoScrollParams = AutoScrollParams(allowedExceptions = emptySet())
}
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun customAssertTest(){
        run {
            steps {
                click(NewOnboardingScreen.skipButton)
                click(ExploreScreenNew.customizeButton)
                NewCustomizeScreen.newCustomizeScreenItem(0){
                    isChecked(checkBox)
                    toggleCheckBox(checkBox)
                    isNotChecked(checkBox)}
                pressBack()
                ExploreScreenNew.newInTheNewsCardItem().perform {newNewsCardItem(2){
                    hasAnyDrawable(newsCardImage)
                    noDrawable(newsCardImage)}
                }
                pressBack()
            }
        }
    }
}