package org.wikipedia.homeworks.homework19

import androidx.test.uiautomator.UiDevice
import com.kaspersky.kaspresso.device.Device
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions

class Steps(private val textContext: TestContext<*>) {

    fun click(item: BaseActions, name: String = defaultName(item)) {
        execute("Нажимает на элемент '$name'") {
            item.click()
        }
    }

    fun isVisible(item: BaseAssertions, name: String = defaultName(item)) {
        execute("Проверяем видимость элемента '$name'") {
            item.isVisible()
        }
    }

    fun sleep(time: Long) {
        execute("Сделать паузу в $time миллисекунд") {
            Thread.sleep(time)
        }
    }

    fun disableNetwork(device: Device) {
        execute("Отключаем сеть"){
            device.network.toggleWiFi(false)
        }
    }

    fun enableNetwork(device: Device) {
        execute("Включаем сеть") {
            device.network.toggleWiFi(true)
        }
    }

    fun typeText(item: EditableActions, text: String) {
        execute("Печатаем текст '$text'") {
            item.replaceText(text)
        }
    }

    fun setChecked(item: CheckableActions, state: Boolean, name: String = defaultName(item)) {
        execute("Устанавливаем состояние '$name' в '$state'") {
            item.setChecked(state)
        }
    }

    fun setOrientationLeft(device: Device) {
        execute("Поворачиваем устройство влево") {
            device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationRight(device: Device) {
        execute("Поворачиваем устройство вправо") {
            device.uiDevice.setOrientationRight()
        }
    }

    fun setOrientationNatural(device: Device) {
        execute("Устанавливаем ориентацию по умолчанию") {
            device.uiDevice.setOrientationNatural()
        }
    }

    fun hasText(item: TextViewAssertions, text: String, name: String = defaultName(item)) {
        execute("Проверяем у элемента '$name' наличие текста '$text'") {
            item.hasText(text)
        }
    }

    fun hasAnyText(item: TextViewAssertions, name: String = defaultName(item)) {
        execute("Проверяем у элемента '$name' наличие любого текста") {
            item.hasAnyText()
        }
    }

    fun containsText(item: TextViewAssertions, text: String, name: String = defaultName(item)) {
        execute("Проверяем что элемент '$name' содержит текст '$text'") {
            item.containsText(text)
        }
    }

    fun isChecked(item: CheckableAssertions, name: String = defaultName(item)) {
        execute("Проверяем, что элемент '$name' отмечен") {
            item.isChecked()
        }
    }

    fun isNotChecked(item: CheckableAssertions, name: String = defaultName(item)) {
        execute("Проверяем, что элемент '$name' не отмечен") {
            item.isNotChecked()
        }
    }

    fun isDisplayed(item: BaseAssertions, name: String = defaultName(item)) {
        execute("Проверяем, что элемент '$name' отображается") {
            item.isDisplayed()
        }
    }

    fun pressBack(device: Device){
        execute("Нажимаем 'назад'"){
            device.uiDevice.pressBack()
        }
    }

    fun waitForIdle(device: Device, time: Long){
        execute("Ждём пока устаканится в теченинии $time миллисекунд"){
            device.uiDevice.waitForIdle(time)
        }
    }


    private fun execute(stepText: String, actions: (StepInfo) -> Unit) {
        textContext.step(stepText, actions)
    }

    private fun defaultName(item: Any): String {
        val str = item.toString()
        return if (str.contains('@')) "элемент" else str
    }

    operator fun invoke(function: Steps.() -> Unit) {
        function()
    }
}