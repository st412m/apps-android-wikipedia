package org.wikipedia.homeworks.homework23

import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.core.AllOf.allOf
import org.wikipedia.R
import org.wikipedia.homeworks.tools.NamedKScreen
import org.wikipedia.homeworks.tools.setName

object ExploreScreenWithWidget: NamedKScreen<ExploreScreenWithWidget>() {
    override val screenName: String = "Explore Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.setName(withParent("Search widget"))
    }

    val topReadWidget by lazy {
        WidgetTopReadCardViewItem(
            matcher = allOf(
                isDescendantOfA(withId(R.id.feed_view)),
                hasDescendant(withText("Top read"))
            )
        ) {
        }.setName(withParent("Виджет 'Top Read'"))
    }
}