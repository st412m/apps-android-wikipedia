package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val stepsCache = mutableMapOf<TestContext<*>, Steps>()

val TestContext<*>.steps: Steps
//    get() {
//        if (stepsCache.containsKey(this)) {
//            return stepsCache.getValue(this)
//            } else {
//                val step = Steps(this)
//                stepsCache[this] = step
//            return step
//        }
//    }

    get() = stepsCache.getOrPut(this) { Steps(this) }