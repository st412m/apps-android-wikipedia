package org.wikipedia.homeworks.homework22

import org.wikipedia.R
import org.wikipedia.homeworks.homework07.AnnouncementCardViewItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NewInTheNewsCardItem
import org.wikipedia.homeworks.tools.findByID
import org.wikipedia.homeworks.tools.getName
import org.wikipedia.homeworks.tools.invokeByID
import org.wikipedia.homeworks.tools.setName

fun ExploreScreenNew.searchCard(
    targetIndex: Int,
    function: SearchCardViewItem.() -> Unit) {
    ExploreScreenNew.items.invokeByID<SearchCardViewItem>(
        targetIndex = targetIndex,
        targetID = R.id.voice_search_button,
        blockName = "Search Card",
        limiter = ExploreScreenNew.items.getSize()
    ) {
        setName(ExploreScreenNew.items.getName().withParent("Блок поиска"))
        function()
    }
}

fun ExploreScreenNew.getSearchCard(): SearchCardViewItem {
    return ExploreScreenNew.items.findByID<SearchCardViewItem>(
        targetIndex = 1,
        targetID = R.id.voice_search_button,
        blockName = "Search Card",
        limiter = ExploreScreenNew.items.getSize()
    ).apply {
        setName(ExploreScreenNew.items.getName().withParent("Блок поиска"))
    }
}

fun ExploreScreenNew.announcementCard(
    targetIndex: Int,
    function: AnnouncementCardViewItem.() -> Unit) {
   ExploreScreenNew.items.invokeByID<AnnouncementCardViewItem>(
        targetIndex = targetIndex,
        targetID = R.id.view_announcement_header_image,
        blockName = "Announcement Card",
        limiter = ExploreScreenNew.items.getSize()
    ) {
        setName(ExploreScreenNew.items.getName().withParent("Блок объявления"))
        function()
    }
}

fun ExploreScreenNew.getAnnouncementCard(): AnnouncementCardViewItem {
    return ExploreScreenNew.items.findByID<AnnouncementCardViewItem>(
        targetIndex = 1,
        targetID = R.id.view_announcement_header_image,
        blockName = "Announcement Card",
        limiter = ExploreScreenNew.items.getSize()
    ).apply {
        setName(ExploreScreenNew.items.getName().withParent("Блок объявления"))
    }
}

fun ExploreScreenNew.searchCardAlone(block: SearchCardViewItem.() -> Unit) {
    getSearchCard().apply(block)
}

fun ExploreScreenNew.announcementCardAlone(block: AnnouncementCardViewItem.() -> Unit) {
    getAnnouncementCard().apply(block)
}

fun ExploreScreenNew.newInTheNewsCard(
    targetIndex: Int,
    function: NewInTheNewsCardItem.() -> Unit) {
    ExploreScreenNew.items.invokeByID<NewInTheNewsCardItem>(
        targetIndex = targetIndex,
        targetID = R.id.view_card_header_title,
        blockName = "News Card",
        limiter = ExploreScreenNew.items.getSize()
    ) {
        setName(ExploreScreenNew.items.getName().withParent("Блок новостей"))
        function()
    }
}

fun ExploreScreenNew.getNewInTheNewsCard(targetIndex: Int): NewInTheNewsCardItem {
    return ExploreScreenNew.items.findByID<NewInTheNewsCardItem>(
        targetIndex = targetIndex,
        targetID = R.id.view_card_header_title,
        blockName = "News Card",
        limiter = ExploreScreenNew.items.getSize()
    ).apply {
        setName(ExploreScreenNew.items.getName().withParent("Блок новостей"))
    }
}

