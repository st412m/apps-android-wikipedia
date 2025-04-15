package org.wikipedia.homeworks.homework21

import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.text.TextViewActions

fun BaseActions.customClick(){
    view.perform(CustomViewAction())
}

fun BaseActions.getText(): String {
    val text = GetText()
    view.perform(text)
    return text.getText()
}