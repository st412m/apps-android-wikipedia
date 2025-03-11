package org.wikipedia.homeworks.homework12

import androidx.test.espresso.AmbiguousViewMatcherException
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

class TestClass : TestCase(
    kaspressoBuilder = Kaspresso.Builder.advanced{
        flakySafetyParams = FlakySafetyParams.custom(
            timeoutMs = 30000,
            allowedExceptions = FlakySafetyParams.defaultAllowedExceptions.plus(AmbiguousViewMatcherException::class.java)
        )
    }
)
