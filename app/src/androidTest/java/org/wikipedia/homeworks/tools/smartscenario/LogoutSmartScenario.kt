package org.wikipedia.homeworks.tools.smartscenario

import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import org.wikipedia.homeworks.homework29.MoreScreen
import org.wikipedia.homeworks.homework29.SettingsScreen

class LogoutSmartScenario(testContext: TestContext<*>) : BaseSmartScenario(testContext) {
    override val stepInfo: String = "Разлогинивает из приложения"
    override val action: (StepInfo) -> Unit = {
        val screenHeight = testContext.device.uiDevice.displayHeight
        val screenWidth = testContext.device.uiDevice.displayWidth
        MoreScreen.settingsButton.click()
        testContext.device.uiDevice.swipe(
            screenWidth / 2, (screenHeight * 0.8).toInt(),
            screenWidth / 2, (screenHeight * 0.2).toInt(),
            20
        )
        SettingsScreen.logoutButton.click()
        testContext.device.uiDevice.findObject(
            UiSelector().text("Log out"),
        ).click()
    }

    override fun isConditionMet() = waitElementById("design_bottom_sheet")
}