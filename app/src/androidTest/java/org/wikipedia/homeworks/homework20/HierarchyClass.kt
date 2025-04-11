package org.wikipedia.homeworks.homework20

class HierarchyClass(
    val name: String,
    val parent: HierarchyClass? = null
) {
    fun withParent(currentElementName: String) =
        HierarchyClass(currentElementName, this)

    override fun toString(): String {
        return if (parent == null) name
        else "$parent : $name"
    }
}
