package org.wikipedia.homeworks.namedElements

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.homeworks.homework20.NamedSteps

private val stepsCache = mutableMapOf<TestContext<*>, NamedSteps>()
val TestContext<*>.steps: NamedSteps
    get() = stepsCache.getOrPut(this) { NamedSteps(this) }