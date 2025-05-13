package org.wikipedia.homeworks.tools.smartscenario

import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo

private const val WAITING_TIME_L = 100L

abstract class BaseSmartScenario(val testContext: TestContext<*>) {
    abstract val stepInfo: String
    abstract val action: (StepInfo) -> Unit
    abstract fun isConditionMet(): Boolean

    private val resourceIdPrefix: String
        get() = "${testContext.device.targetContext.packageName}:id/"

    fun init(): Boolean {
        val conditions = isConditionMet()
        if (conditions) {
            testContext.step(stepInfo, action)
        }
        return conditions
    }

    fun waitElementById(id: String) = getElementById(id).waitForExists(WAITING_TIME_L)

    fun waitElementByText(text: String) = getElementByText(text).waitForExists(WAITING_TIME_L)

    fun waitElementByClassName(className: String) = getElementByClassName(className).waitForExists(WAITING_TIME_L)

    fun waitElementAsBalloon(id: String): Boolean {
        return getElementAsBalloon(id) != null
    }

    private fun getElementById(id: String): UiObject {
        return testContext
            .device
            .uiDevice
            .findObject(
                UiSelector()
                    .resourceId("$resourceIdPrefix$id")
            )
    }

    private fun getElementByText(text: String): UiObject {
        return testContext
            .device
            .uiDevice
            .findObject(
                UiSelector()
                    .textContains(text)
            )
    }

    private fun getElementByClassName(className: String): UiObject {
        return testContext
            .device
            .uiDevice
            .findObject(
                UiSelector()
                    .className(className)
            )
    }

    internal fun getElementAsBalloon(id: String): UiObject2? {
        return testContext
            .device
            .uiDevice
            .wait(
                Until.findObject(By.res("$resourceIdPrefix$id")),
                5000
            )
    }

    internal fun getElementByTextSecond(text: String): UiObject2? {
        return testContext
            .device
            .uiDevice
            .findObject(
                By.textContains(text)
            )
    }
}
