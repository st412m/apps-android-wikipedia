package org.wikipedia.homeworks.tools

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import kotlin.math.min

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndex(
    targetIndex: Int,
    function: T.() -> Unit
) {
    val recycler: KRecyclerView = this
    childAt<T>(targetIndex) {
        setName(recycler.getName().withParent("$targetIndex"))
        function()
    }
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeByID(
    targetIndex: Int,
    targetID: Int,
    blockName: String,
    limiter: Int,
    function: T.() -> Unit
) {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetID)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                setName(recycler.getName().withParent("$targetIndex's block of $blockName"))
                function()
                return
            }
        }
    }
    throw NoSuchElementException("Not found block with $targetIndex index of $blockName")

}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.findByID(
    targetIndex: Int,
    targetID: Int,
    limiter: Int,
    blockName: String
): T {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetID)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                setName(recycler.getName().withParent("$targetIndex's block of $blockName"))
                return this
            }
        }
    }
    throw NoSuchElementException("Not found block with $targetIndex index of $blockName")
}