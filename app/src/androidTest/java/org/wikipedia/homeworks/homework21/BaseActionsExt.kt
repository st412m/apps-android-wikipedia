package org.wikipedia.homeworks.homework21

import io.github.kakaocup.kakao.common.actions.BaseActions

fun BaseActions.customClick(){
    view.perform(CustomViewAction())
}

fun BaseActions.getText(): String {
    val text = GetText()
    view.perform(text)
    return text.getText()
}