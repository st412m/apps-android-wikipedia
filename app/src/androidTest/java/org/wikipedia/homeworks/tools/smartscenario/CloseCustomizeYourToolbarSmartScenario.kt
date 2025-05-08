package org.wikipedia.homeworks.tools.smartscenario

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo

class CloseCustomizeYourToolbarSmartScenario(testContext: TestContext<*>) :
    BaseSmartScenario(testContext) {
    override val stepInfo: String = "Закрывает Balloon кастомизации тулбара"
    override val action: (StepInfo) -> Unit = {
        getElementAsBalloon("buttonView")?.click()
    }

    override fun isConditionMet() = waitElementAsBalloon("balloon")
}
