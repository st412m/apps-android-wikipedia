package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import java.lang.Thread.*
import java.util.Locale

class DeviceTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deviceTest(){
        before {
            device.network.disable()
        }.after {
            device.network.enable()
        }.run {
//            device.uiDevice.findObject(UiSelector().text("").index(2)).bounds
//            device.files
//            device.apps
//            device.logcat
//            device.phone
//            device.accessibility
            device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
//            device.language.switchInApp(Locale.UK)
            device.network.toggleWiFi(false)
            Thread.sleep(3000)
            device.network.toggleWiFi(true)
            adbServer


        }
    }
}