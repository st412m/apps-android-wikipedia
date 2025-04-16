package org.wikipedia.homeworks.homework21

import io.github.kakaocup.kakao.common.actions.BaseActions

fun BaseActions.toggleCheckBox() {
    view.perform(ToggleCheckBoxAction())
}