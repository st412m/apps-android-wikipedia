package org.wikipedia.homeworks.namedElements

class NameHierarchyClass(
    val name: String,
    private val parent: NameHierarchyClass? = null
) {
    fun withParent(currentElementName: String) =
        NameHierarchyClass(currentElementName, this)

    override fun toString(): String {
        return if (parent == null) name
        else "$parent : $name"
    }
}
