package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.actions.BaseActions

val elementNames = mutableMapOf<BaseActions, HierarchyClass>()

fun <T: BaseActions> T.setName(hierarchyClass: HierarchyClass): T{
    elementNames[this] = hierarchyClass
    return this
}

fun BaseActions.getName(): HierarchyClass{
    return (elementNames[this] ?: "NO LABEL") as HierarchyClass
}

fun BaseActions.withParent(elementName: String) = getName().withParent(elementName)