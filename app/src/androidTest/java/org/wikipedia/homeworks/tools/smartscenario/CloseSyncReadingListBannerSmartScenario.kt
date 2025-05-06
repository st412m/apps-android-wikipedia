package org.wikipedia.homeworks.tools.smartscenario

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.views.KView

class CloseSyncReadingListBannerSmartScenario(testContext: TestContext<*>) : BaseSmartScenario(testContext) {
    override val stepInfo: String = "Закрывает окно с предложением синхронизации списка чтения"
    override val action: (StepInfo) -> Unit = {
        KView {
            withId(android.R.id.button2)
        }.click()
    }

    override fun isConditionMet() = waitElementById("action_bar_root")
}
