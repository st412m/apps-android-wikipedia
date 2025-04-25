package org.wikipedia.homeworks.tools

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import io.github.kakaocup.kakao.web.KWebView
import io.github.kakaocup.kakao.web.WebActions
import org.wikipedia.homeworks.homework21.hasAnyDrawable
import org.wikipedia.homeworks.homework21.noDrawable
import org.wikipedia.homeworks.homework21.toggleCheckBox
import org.wikipedia.homeworks.homework24.KWebViewBaseElement
import org.wikipedia.homeworks.homework24.KWebViewElement

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
        execute("Отключаем сеть") {
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

    fun swipeVertically(screens: Double, steps: Int, isUp: Boolean = true) {
        execute("Выполняем вертикальный свайп на $screens экрана с шагом $steps в направлении вверх - $isUp") {
            val displayWidth = testContext.device.uiDevice.displayWidth
            val displayHeight = testContext.device.uiDevice.displayHeight

            val startX = displayWidth / 2
            val startY = (displayHeight * if (isUp) 0.66 else 0.33).toInt()
            val endY = (startY + (displayHeight * if (isUp) -screens else screens)).toInt()

            val clampedEndY = endY.coerceIn(0, displayHeight)

            try {
                testContext.device.uiDevice.swipe(startX, startY, startX, clampedEndY, steps)
            } catch (e: Exception) {
                println("Ошибка при вертикальном свайпе: ${e.message}")
            }
        }
    }

    fun swipeHorizontally(screens: Double, steps: Int, isRight: Boolean = true) {
        execute("Выполняем горизонтальный свайп на $screens экранов с шагом $steps в направлении вправо - $isRight") {
            val displayWidth = testContext.device.uiDevice.displayWidth
            val displayHeight = testContext.device.uiDevice.displayHeight

            val startY = displayHeight / 2
            val startX = (displayWidth * if (isRight) 0.66 else 0.33).toInt()
            val endX = (startX + (displayWidth * if (isRight) -screens else screens)).toInt()

            val clampedEndX = endX.coerceIn(0, displayWidth)

            try {
                testContext.device.uiDevice.swipe(startX, startY, endX, clampedEndX, steps)
            } catch (e: Exception) {
                println("Ошибка при горизонтальном свайпе: ${e.message}")
            }
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

    fun pressBack() {
        execute("Нажимаем 'назад'") {
            testContext.device.uiDevice.pressBack()
        }
    }

    fun waitForIdle(time: Long) {
        execute("Ждём пока устаканится в теченинии $time миллисекунд") {
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
    fun scroll(item: WebActions) {
        execute("Scroll '${(item as BaseActions).getName()}'") {
            item.scroll()
        }
    }

    fun scroll(item: KWebViewElement) {
        execute("Scroll '${item.getName()}'") {
            testContext.flakySafely(5000) {
                item.executeAction { scroll() }
            }
        }
    }


    private fun execute(stepText: String, actions: (StepInfo) -> Unit) {
        testContext.step(stepText, actions)
    }

    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
    }
}





