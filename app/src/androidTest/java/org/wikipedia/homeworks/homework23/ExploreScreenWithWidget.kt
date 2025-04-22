package org.wikipedia.homeworks.homework23

import org.wikipedia.R
import org.wikipedia.homeworks.tools.KWidget
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
}