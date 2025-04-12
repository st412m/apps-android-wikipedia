package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.screens.KScreen

abstract class NamedKScreen<out T : KScreen<T>> : KScreen<T>(){
    abstract val screenName: String
    private val nameHierarchyClass by lazy {NameHierarchyClass(screenName)}

    fun withParent(elementName:String) = nameHierarchyClass.withParent(elementName)

}
