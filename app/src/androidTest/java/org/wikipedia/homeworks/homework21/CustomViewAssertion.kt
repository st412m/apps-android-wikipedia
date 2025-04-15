package org.wikipedia.homeworks.homework21

import android.view.View
import android.widget.TextView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert

class CustomViewAssertion(val text: String) : ViewAssertion {
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (view is TextView) {
            view.text
            Assert.assertEquals(text, view.text)
        } else {
            throw (noViewFoundException ?: AssertionError("View is not text"))
        }
    }
}