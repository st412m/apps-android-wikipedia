package org.wikipedia.homeworks.homework27

import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.wikipedia.homeworks.tools.allureinterceptors.FailOnlyScreenshotStepInterceptor
import org.wikipedia.homeworks.tools.allureinterceptors.SuccessFinaleScreenshotTestInterceptor

class AllureSupportTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        stepWatcherInterceptors.removeIf {
            it is ScreenshotStepInterceptor
        }
        stepWatcherInterceptors.add(FailOnlyScreenshotStepInterceptor(screenshots))
        testRunWatcherInterceptors.add(SuccessFinaleScreenshotTestInterceptor(screenshots))
    }
)



