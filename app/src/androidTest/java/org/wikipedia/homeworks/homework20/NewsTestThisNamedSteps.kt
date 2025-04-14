package org.wikipedia.homeworks.homework20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.namedElements.steps
import org.wikipedia.main.MainActivity

class NewsTestThisNamedSteps: TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        autoScrollParams = AutoScrollParams(allowedExceptions = emptySet())
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun newsTest() {
        run {
            steps {
                click(NewOnboardingScreen.skipButton)
                click(ExploreScreenNew.customizeButton)
                NewCustomizeScreen.newCustomizeScreenItem(0){isChecked(checkBox)}
                NewCustomizeScreen.newCustomizeScreenItem(1){
                    setChecked(checkBox, false)
                    isNotChecked(checkBox, )
                    setChecked(checkBox, true)
                }
                pressBack()
                ExploreScreenNew.newInTheNewsCardItem().perform {hasAnyText(inTheNewsHeaderTitle)}
                ExploreScreenNew.newInTheNewsCardItem().perform {newNewsCardItem(2){click(newsCardImage)}}
                NewFragmentNews.newFragmentNewsCardItems(1){click(newsCardItemTitle)}
                click(NewNewsPage.searchToolbar)
                typeText(NewSearchScreen.searchField, "Проверка ввода")
                hasText(NewSearchScreen.searchField, "Проверка ввода")
                containsText(NewSearchScreen.searchField, "вво")
                pressBack()
             }
        }
    }
}