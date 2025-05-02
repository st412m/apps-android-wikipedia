package org.wikipedia.homeworks.tools.smartscenario

class ListOfSmartScenario(private val list: List<BaseSmartScenario>) {
    fun execute() = list.any {it.init()}
}