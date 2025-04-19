package org.wikipedia.homeworks.tools

import android.view.View
import io.github.kakaocup.kakao.common.actions.BaseActions

fun BaseActions.hasClassAction(targetClass: Class<out View>): Boolean {
    val checker = HasClassAction(targetClass)
    view.perform(checker)
    return checker.isMatched()
}