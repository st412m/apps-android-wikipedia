package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions

class Steps(private val textContext : TestContext<*>) {

    fun click(item: BaseActions, name: String) {
        execute("Нажимает на элемент '$name'") {
            item.click()
        }
    }

    fun isVisible(item: BaseAssertions, name: String){
        execute("Проверяем видимость элемента '$name'"){
            item.isVisible()
        }
    }

    fun sleep(time: Long){
        execute("Сделать паузу в $time миллисекунд") {
            Thread.sleep(time)
        }
    }

    private fun execute(stepText: String, actions: (StepInfo) -> Unit){
        textContext.step(stepText, actions)
    }

    operator fun invoke(function: Steps.() -> Unit){
        function()
    }
}