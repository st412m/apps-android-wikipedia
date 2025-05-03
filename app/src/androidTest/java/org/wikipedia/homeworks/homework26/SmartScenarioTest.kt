package org.wikipedia.homeworks.homework26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NewFragmentNews
import org.wikipedia.homeworks.homework20.NewNewsPage
import org.wikipedia.homeworks.homework20.NewOnboardingScreen
import org.wikipedia.homeworks.tools.smartscenario.CloseCustomizeYourToolbarSmartScenario
import org.wikipedia.homeworks.tools.steps
import org.wikipedia.main.MainActivity

/*
1. Задание выполняем в homeworks/homework26
2. Воспроизвести код из урока
3. Доработать уже существующий класс с шагами, добавив в него обход мешающих банеров.
4. Написать сценарий, в котором нужно перейти любым способом в статью, нажать в нижнем баре кнопку
"Save" в виде иконки флажка вниз. Нажать кнопку назад, Нажать кнопку Saved в нижнем навбаре.
Этому помешает банер Sync readings list. Добавить смартсценарий, который будет обрабатывать этот
банер и не позволит тесту падать.
 */

class SmartScenarioTest: TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
    autoScrollParams = AutoScrollParams(allowedExceptions = emptySet())
}
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun smartScenarioTest() {
        run {
            val checkYourToolbar = CloseCustomizeYourToolbarSmartScenario(this)
            val checkSyncReading = CloseCustomizeYourToolbarSmartScenario(this)
            steps {
                NewOnboardingScreen {
                    checkSyncReading.init()
                    click(skipButton)
                }
                ExploreScreenNew.newInTheNewsCardItem()
                    .perform { newNewsCardItem(1) { click(newsCardImage) } }
                NewFragmentNews.newFragmentNewsCardItems(1) {
                    click(newsCardItemTitle)
                }
                NewNewsPage{
                    click(saveButton)
                }
                pressBack()
                NewFragmentNews.newFragmentNewsCardItems(0) {
                    click(newsCardItemTitle)
                }
                NewNewsPage{
                    click(saveButton)
                }
                pressBack()
                pressBack()

                ExploreScreenNew{
                    click(savedButton)
                }
            }
        }
    }
}