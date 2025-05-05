package org.wikipedia.homeworks.tools.smartscenario

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R

class CloseCustomizeYourToolbarSmartScenario(testContext: TestContext<*>) : BaseSmartScenario(testContext) {
    override val stepInfo: String = "Закрывает Balloon кастомизации тулбара"
    override val action: (StepInfo) -> Unit = {
        KView {
            withId(R.id.buttonView)
        }.click()
    }

    override fun isConditionMet() = waitElementById("balloon")
}
