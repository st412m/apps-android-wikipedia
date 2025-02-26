package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object NewsPage: KScreen<NewsPage>() {
    override val layoutId = null
    override val viewClass = null

    val newsPageWebView = KView{
        withId(R.id.page_web_view)
    }

   val newsPageToolbar = KToolbar{
       withId(R.id.page_toolbar)
   }

    val newsPageToolbarButtonSearch = KTextView{
        withId(R.id.page_toolbar_button_search)
    }

    val newsPageToolbarButtonTabs = KTextView{
        withId(R.id.tabsCountText)
    }

    val newsPageToolbarShowOverFlowMenu = KImageView{
        withId(R.id.page_toolbar_button_show_overflow_menu)
    }

    val newsPageArticleCardImage = KImageView{
        withId(R.id.articleImage)
    }

    val newsPageArticleTitle = KTextView{
        withId(R.id.articleTitle)
    }

    val newsPageArticleDescription = KTextView{
        withId(R.id.articleDescription)
    }

    val newsPageArticleExtract = KTextView{
        withId(R.id.articleExtract)
    }
}