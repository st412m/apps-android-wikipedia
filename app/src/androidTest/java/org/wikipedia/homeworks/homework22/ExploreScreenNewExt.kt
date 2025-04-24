package org.wikipedia.homeworks.homework22

import org.wikipedia.R
import org.wikipedia.feed.searchbar.SearchCardView
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.tools.invokeByClass
import org.wikipedia.homeworks.tools.invokeById

fun ExploreScreenNew.searchCardItemById(targetIndex: Int = 0, function: SearchCardViewItem.() -> Unit) {
    items.invokeById(
        targetIndex = targetIndex,
        targetId = R.id.voice_search_button,
        blockName = "Search Card",
        limiter = (4 * targetIndex).coerceAtLeast(5),
        function = function
    )
}

fun ExploreScreenNew.searchCardItemByClass(targetIndex: Int = 0, function: SearchCardViewItem.() -> Unit) {

    items.invokeByClass(
        targetIndex = targetIndex,
        targetClass = SearchCardView::class.java,
        blockName = "Search Card",
        limiter = (4 * targetIndex).coerceAtLeast(5),
        function = function
    )
}

fun ExploreScreenNew.announcementCardItemById(targetIndex: Int = 0, function: SearchCardViewItem.() -> Unit) {
    items.invokeById(
        targetIndex = targetIndex,
        targetId = R.id.view_announcement_header_image,
        blockName = "Картинка",
        limiter = (4 * targetIndex).coerceAtLeast(5),
        function = function
    )
}



