package org.wikipedia.homeworks

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.wikipedia.homeworks.homework08.ExploreTestScreen
import org.wikipedia.homeworks.homework11.DeviceTestInTheNews
import org.wikipedia.homeworks.homework13.TopReadWebViewTest

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ExploreTestScreen::class,
    DeviceTestInTheNews::class,
    TopReadWebViewTest::class
)
class TestSuite {
}