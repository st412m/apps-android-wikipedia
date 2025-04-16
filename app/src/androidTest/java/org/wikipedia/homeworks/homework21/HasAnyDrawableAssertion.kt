package org.wikipedia.homeworks.homework21

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert

class HasAnyDrawableAssertion : ViewAssertion {
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (view is ImageView) {
            Assert.assertNotNull("КImageView не содержит изображение", view.drawable)
        } else {
            throw (noViewFoundException ?: AssertionError("View не является КImageView"))
        }
    }
}
