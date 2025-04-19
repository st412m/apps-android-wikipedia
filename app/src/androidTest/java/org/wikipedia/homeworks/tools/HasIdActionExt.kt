package org.wikipedia.homeworks.tools

import io.github.kakaocup.kakao.common.actions.BaseActions

fun BaseActions.hasIdAction(targetID: Int): Boolean {
    val checker = HasIdAction(targetID)
    view.perform(checker)
    return checker.isMatched()
}