package org.wikipedia.examples

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.greaterThanOrEqualTo
import org.hamcrest.Matchers.`in`
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.lessThanOrEqualTo
import org.junit.Assert.assertTrue
import org.hamcrest.Description
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher

data class SuspiciousActivity(val isDetected: Boolean, val suspicionLevel: Int, val notes: String)

fun ifStyle(activity: SuspiciousActivity) {  //не очень хорошая практика - некрасиво и запутано
    if (!activity.isDetected ||
        activity.suspicionLevel !in 5..10 ||
        !(activity.notes == "unusual behavior" || activity.notes == "unauthorized access")
    ) {

        throw AssertionError("Verification failed for: $activity")
    }
}

fun assertStyle(activity: SuspiciousActivity) { // плох тем, что кроме asserta нужно писать текст
    // ошибки, в противном случае, в случае падения теста, будет непонятно что именно произошло
    assertTrue("Activity should be detected", activity.isDetected)
    assertTrue(
        "Suspicion level should be within the range 5 to 10",
        activity.suspicionLevel in 5..10,
    )
    assertTrue(
        "Notes should be valid",
        activity.notes == "unusual behavior" || activity.notes == "unauthorized access"
    )
}

fun matcherStyle(activity: SuspiciousActivity) {
    assertThat("isDetected field", activity.isDetected, `is`(true))

    assertThat(
        "suspicionLevel field",
        activity.suspicionLevel,
        allOf(greaterThanOrEqualTo(5), lessThanOrEqualTo(10))
    )

    assertThat(
        "notes field",
        activity.notes,
        anyOf(equalTo("unusual behavior"), `in`(listOf("unauthorized access")))
    )
}

class IsDetectedMatcher(
    private val isDetected: Boolean
) : TypeSafeMatcher<SuspiciousActivity>() {
    override fun describeTo(description: Description) {
        description.appendText("isDetected is $isDetected")
    }

    override fun matchesSafely(activity: SuspiciousActivity): Boolean {
        return activity.isDetected == isDetected
    }
}

class SuspicionLevelInRangeMatcher(
    private val min: Int,
    private val max: Int
) : TypeSafeMatcher<SuspiciousActivity>() {
    override fun describeTo(description: Description) {
        description.appendText("suspicionLevel is between $min and $max")
    }

    override fun matchesSafely(activity: SuspiciousActivity): Boolean {
        return activity.suspicionLevel in min..max
    }
}

class NotesInMatcher(private val validNotes: List<String>) : TypeSafeMatcher<SuspiciousActivity>() {
    override fun describeTo(description: Description) {
        description.appendText("notes is one of $validNotes")
    }

    override fun matchesSafely(activity: SuspiciousActivity): Boolean {
        return activity.notes in validNotes
    }
}

fun main() {
    val activities = listOf(
        SuspiciousActivity(true, 5, "unauthorized access"),
        SuspiciousActivity(false, 4, "unauthorized access")
    )

    val matchers = allOf(
        SuspicionLevelInRangeMatcher(3,4),
        NotesInMatcher(listOf("unauthorized access", "security breach"))
    )
    val result = activities.filter { matchers.matches(it) }


    println(result)
}

