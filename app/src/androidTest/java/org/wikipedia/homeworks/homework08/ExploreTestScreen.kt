package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadCardViewItem
import org.wikipedia.main.MainActivity
import retrofit2.http.GET

class ExploreTestScreen : TestCase(){

    @get:Rule
    val activityScenarioRule : ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest(){
        run {
            step("Скипаем с главной"){

            }

            step("Проверяет отображение тулбара"){
                ExploreScreen.toolbarTitle.isDisplayed()
            }
            step("проверяем иконку микрофона"){
                ExploreScreen.items.childAt<SearchCardViewItem>(0){
                    voiceIcon.isDisplayed()
                }
            }
        }
    }
}