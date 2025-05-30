package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
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
import java.io.File
import java.util.Locale

class DeviceTestInTheNews : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get: Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test

    fun inTheNewsDeviceTest() {
        before {

        }.after {
            device.network.toggleWiFi(true)
            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
            device.language.switchInApp(Locale.ENGLISH)
        }.run {
            step("Поворачиваем экран и проверяем ориентацию") {
                device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
                if (!device.uiDevice.isNaturalOrientation) {
                    device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
                }
            }
            step("Выключаем экран и проверяем наличие кнопки 'Skip'") {
                device.uiDevice.sleep()
                Thread.sleep(5000)
                device.uiDevice.wakeUp()
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Покидаем onboarding") {
                OnboardingScreen.skipButton.click()
            }
            step(
                "Сворачиваем приложение, потом разворачивааем и проверяем есть ли у нас " +
                        "блок 'In the news'"
            ) {
                device.uiDevice.pressHome()
                device.uiDevice.pressRecentApps()
                device.uiDevice.waitForIdle()
                Thread.sleep(2000)
                device.uiDevice.pressRecentApps()

                ExploreScreen.items.childWith<InTheNewsCardItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    inTheNewsHeaderTitle.hasAnyText()
                }
            }
            step("Листаем до третьей картинки и кликаем на неё") {
                ExploreScreen.items.childWith<InTheNewsCardItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    newsCardReaderItems.childAt<NewsCardItem>(2) {
                        newsCardImage.click()
                    }
                }
            }
            step("Вырубаем сеть и кликаем по второй статье из списка") {
                val retryButton = device.uiDevice.findObject(UiSelector().text("Retry"))
                device.network.toggleWiFi(false)
                FragmentNews.newsStoryItemsRecycler.childAt<NewsCardItems>(1) {
                    newsCardItemTitle.click()
                }
                if (retryButton.exists()) {
                    device.network.toggleWiFi(true)
                    device.uiDevice.waitForIdle()
                    Thread.sleep(5000)
                    retryButton.click()
                }
            }
            step("Проверяем, что отображается элемент с ID page_web_view") {
                NewsPage.newsPageWebView.isDisplayed()
            }
            step(
                "переключаем язык приложения, возвращаемся назад  и проверяем, что язык " +
                        "на кнопки Customize соответсвет "
            ) {
                repeat(2) {
                    device.uiDevice.pressBack()
                }

                repeat(4) {
                    ExploreScreen.items.swipeDown()
                    Thread.sleep(500)
                }
                //Entdecken
                device.uiDevice.waitForIdle()
                device.language.switchInApp(Locale.GERMAN)
                val navLabel = device.uiDevice.findObject(
                    UiSelector().resourceId(
                        "org.wikipedia.alpha:id/navigation_bar_item_large_label_view"
                    )
                )
                Assert.assertEquals("Entdecken", navLabel.text)
            }
            step("Проверяем, что сейчас активна MainActivity") {
                device.activities.isCurrent(MainActivity::class.java)
            }

            step("Делаем скриншот и сохраняем его в папку с домашкой") {
                val screenshotPathOnDevice = File("/storage/emulated/0/DCIM/Screenshots/screenshot")
                val targetPath =
                    File("app/src/androidTest/java/org/wikipedia/homeworks/homework11/screenshot.png")
                device.screenshots.take(screenshotPathOnDevice.toString())
                val command = "pull"
                val arguments = listOf("${screenshotPathOnDevice}.png", targetPath.toString())
                adbServer.performAdb(command, arguments)
            }
        }
    }
}

