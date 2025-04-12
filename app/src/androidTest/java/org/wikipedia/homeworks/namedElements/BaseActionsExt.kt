package org.wikipedia.homeworks.namedElements

import io.github.kakaocup.kakao.common.actions.BaseActions

val elementNames = mutableMapOf<BaseActions, NameHierarchyClass>()

fun <T: BaseActions> T.setName(nameHierarchyClass: NameHierarchyClass): T{
    elementNames[this] = nameHierarchyClass
    return this
}

fun BaseActions.getName(): NameHierarchyClass {
    return elementNames[this] ?: throw RuntimeException("Необходимо указать имя")
}

fun BaseActions.withParent(elementName: String) = getName().withParent(elementName)