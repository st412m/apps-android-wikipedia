package org.wikipedia.homeworks.namedElements

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.homeworks.homework21.ToggleCheckBoxAction
import org.wikipedia.homeworks.homework21.hasAnyDrawable
import org.wikipedia.homeworks.homework21.noDrawable
import org.wikipedia.homeworks.homework21.toggleCheckBox

class NamedSteps(private val testContext: TestContext<*>) {

    fun click(item: BaseActions) {
        execute("Нажимает на элемент '${item.getName()}'") {
            item.click()
        }
    }

    fun isVisible(item: BaseAssertions) {
        execute("Проверяем видимость элемента  '${(item as BaseActions).getName()}'") {
            item.isVisible()
        }
    }
    fun sleep(time: Long) {
        execute("Сделать паузу в $time миллисекунд") {
            Thread.sleep(time)
        }
    }

    fun disableNetwork() {
        execute("Отключаем сеть"){
            testContext.device.network.toggleWiFi(false)
        }
    }

    fun enableNetwork() {
        execute("Включаем сеть") {
            testContext.device.network.toggleWiFi(true)
        }
    }

    fun typeText(item: EditableActions, text: String) {
        execute("Печатаем текст '$text'") {
            item.replaceText(text)
        }
    }

    fun setChecked(item: CheckableActions, state: Boolean) {
        execute("Устанавливаем состояние '${(item as BaseActions).getName()}' в '$state'") {
            item.setChecked(state)
        }
    }

    fun setOrientationLeft() {
        execute("Поворачиваем устройство влево") {
            testContext.device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationRight() {
        execute("Поворачиваем устройство вправо") {
            testContext.device.uiDevice.setOrientationRight()
        }
    }

    fun setOrientationNatural() {
        execute("Устанавливаем ориентацию по умолчанию") {
            testContext.device.uiDevice.setOrientationNatural()
        }
    }

    fun hasText(item: TextViewAssertions, text: String) {
        execute("Проверяем у элемента '${(item as BaseActions).getName()}' наличие текста '$text'") {
            item.hasText(text)
        }
    }

    fun hasAnyText(item: TextViewAssertions) {
        execute("Проверяем у элемента '${(item as BaseActions).getName()}' наличие любого текста") {
            item.hasAnyText()
        }
    }

    fun containsText(item: TextViewAssertions, text: String) {
        execute("Проверяем что элемент '${(item as BaseActions).getName()}' содержит текст '$text'") {
            item.containsText(text)
        }
    }

    fun isChecked(item: CheckableAssertions) {
        execute("Проверяем, что элемент '${(item as BaseActions).getName()}' отмечен") {
            item.isChecked()
        }
    }

    fun isNotChecked(item: CheckableAssertions) {
        execute("Проверяем, что элемент '${(item as BaseActions).getName()}' не отмечен") {
            item.isNotChecked()
        }
    }

    fun isDisplayed(item: BaseAssertions) {
        execute("Проверяем, что ${(item as BaseActions).getName()} отображается") {
            item.isDisplayed()
        }
    }

    fun pressBack(){
        execute("Нажимаем 'назад'"){
            testContext.device.uiDevice.pressBack()
        }
    }

    fun waitForIdle(time: Long){
        execute("Ждём пока устаканится в теченинии $time миллисекунд"){
            testContext.device.uiDevice.waitForIdle(time)
        }
    }
    fun noDrawable(item: BaseAssertions) {
        execute("Проверяем, что элемент '${(item as BaseActions).getName()}' не содержит изображение") {
            item.noDrawable()
        }
    }

    fun hasAnyDrawable(item: BaseAssertions) {
        execute("Проверяем, что элемент '${(item as BaseActions).getName()}' содержит изображение") {
            item.hasAnyDrawable()
        }
    }

    fun toggleCheckBox(item: BaseActions) {
        execute("Переключаем состояние чекбокса '${item.getName()}'") {
            item.toggleCheckBox()
        }
    }

    private fun execute(stepText: String, actions: (StepInfo) -> Unit) {
        testContext.step(stepText, actions)
    }

    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
    }
}


