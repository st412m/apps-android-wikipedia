package org.wikipedia.homeworks.homework21

import android.view.View
import android.widget.Checkable
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class ToggleCheckBoxAction : ViewAction {
    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "Переключение состояния чекбокса"
    }

    override fun perform(uiController: UiController?, view: View?) {
        if (view is Checkable) {
            view.isChecked = !view.isChecked
        } else {
            throw IllegalStateException("View не реализует Checkable")
        }
    }
}