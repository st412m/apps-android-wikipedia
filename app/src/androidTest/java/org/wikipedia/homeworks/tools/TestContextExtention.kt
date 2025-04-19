package org.wikipedia.homeworks.tools

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val stepsCache = mutableMapOf<TestContext<*>, NamedSteps>()
val TestContext<*>.steps: NamedSteps
    get() = stepsCache.getOrPut(this) { NamedSteps(this) }