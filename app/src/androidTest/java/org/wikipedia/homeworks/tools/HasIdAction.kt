package org.wikipedia.homeworks.tools

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HasIdAction(private val id: Int) : ViewAction {
    private var result: Boolean = false
    fun isMatched(): Boolean = result

    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "Проверяем элемент с определенным Id"
    }


    override fun perform(uiController: UiController?, view: View?) {
        val nonNullView = requireNotNull(view) { "View must not be null" }
        result = when {
            nonNullView.id == id -> true
            nonNullView.findViewById<View>(id) != null -> true
            else -> false
        }
    }
}

