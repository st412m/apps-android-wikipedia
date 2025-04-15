package org.wikipedia.homeworks.homework21

import io.github.kakaocup.kakao.text.TextViewActions

fun TextViewActions.getText(): String {
    val text = GetText()
    view.perform(text)
    return text.getText()
}