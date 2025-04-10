package org.wikipedia.homeworks.homework19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework07.NewsCardItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.FragmentNews
import org.wikipedia.homeworks.homework09.NewsCardItems
import org.wikipedia.homeworks.homework09.NewsPage
import org.wikipedia.main.MainActivity

class NewsTestWithCompactSteps : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        autoScrollParams = AutoScrollParams(allowedExceptions = emptySet())
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun newsTest(){
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        run{
            steps {
                click(OnboardingScreen.skipButton, "кнопка skip")
                click(ExploreScreen.customizeButton, "кнопка Customize")
                CustomizeScreen{
                    customizeScreenRecycler.childAt<CustomizeScreenItem>(0){
                        isChecked(checkBox, "Чекбокс Featured article")
                    }
                    customizeScreenRecycler.childAt<CustomizeScreenItem>(1){
                        setChecked(checkBox, false,"Чекбокс Top read")
                        isNotChecked(checkBox,"Чекбокс Top read" )
                        setChecked(checkBox, true,"Чекбокс Top read")
                    }
                }
                pressBack(device)
                ExploreScreen.items.childWith<InTheNewsCardItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    hasAnyText(inTheNewsHeaderTitle)
                }
                ExploreScreen.items.childWith<InTheNewsCardItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    newsCardReaderItems.childAt<NewsCardItem>(2) {
                       click(newsCardImage, "Третья картинка")
                    }
                }
                FragmentNews.newsStoryItemsRecycler.childAt<NewsCardItems>(1) {
                    click(newsCardItemTitle, "Заголовок второй статьи")
                }
                isDisplayed(NewsPage.newsPageWebView, "ID page_web_view")
                setOrientationLeft(device)
                setOrientationNatural(device)
                setOrientationRight(device)
                setOrientationNatural(device)
                disableNetwork(device)
                click(NewsPage.newsPageToolbarButtonSearch)
                sleep(5000)
                typeText(SearchScreen.searchField, "Проверка ввода")
                hasText(SearchScreen.searchField, "Проверка ввода", "поле ввода")
                containsText(SearchScreen.searchField, "вво", "поле ввода")
                enableNetwork(device)
            }
        }
    }
}