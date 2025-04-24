package org.wikipedia.homeworks.tools

import android.content.res.Resources.NotFoundException
import android.view.View
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

inline fun  <reified T : KRecyclerItem<*>> KRecyclerView.invokeById(
    targetIndex: Int,
    targetId: Int,
    blockName: String,
    limiter: Int,
    function: T.() -> Unit
) {
    val recycler = this
    var findBlockCounter = -1
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetId)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                setName(recycler.getName().withParent("$targetIndex's block of $blockName"))
                function()
                return
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}

inline fun  <reified T : KRecyclerItem<*>> KRecyclerView.invokeByClass(
    targetIndex: Int,
    targetClass: Class<out View>,
    blockName: String,
    limiter: Int,
    function: T.() -> Unit
) {
    val recycler = this
    var findBlockCounter = -1
    val max = min(limiter, getSize())
    for (i in 0 until limiter) {
        scrollTo(i + 3)
        childAt<T>(i) {
            if (hasClassAction(targetClass)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                setName(recycler.getName().withParent("$targetIndex's block of $blockName"))
                function()
                return
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}

inline fun  <reified T : KRecyclerItem<*>> KRecyclerView.findById(
    targetIndex: Int,
    targetId: Int,
    limiter: Int,
    blockName: String,
): T {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetId)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                setName(recycler.getName().withParent("$targetIndex's block of $blockName"))
                return this
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}