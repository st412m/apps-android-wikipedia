package org.wikipedia.homeworks.homework19

import androidx.test.ext.junit.rules.ActivityScenarioRule
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
        run{
            steps {
                click(OnboardingScreen.skipButton, "кнопка skip")
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
                click(NewsPage.searchField, "Поле поиска")
                NewsPage.cabSearchView.perform { typeText("хуй") }
            }
        }
    }
}