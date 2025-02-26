package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object FragmentNews : KScreen<FragmentNews>() {
    override val layoutId = null
    override val viewClass = null

    val toolbarFragmentNews = KView{
        withId(R.id.toolbar)
    }

    val headerImage = KImageView{
        withId(R.id.header_image_view)
    }

    val storyText = KTextView{
        withId(R.id.story_text_view)
    }

    val newsStoryItemsRecycler = KRecyclerView(
        builder = {
            withId(R.id.news_story_items_recyclerview)
        },
        itemTypeBuilder = {
            itemType(::NewsCardItems)
        }
    )
}