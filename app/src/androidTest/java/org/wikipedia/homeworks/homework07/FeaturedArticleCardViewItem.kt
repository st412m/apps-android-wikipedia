package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.tools.withParent

class FeaturedArticleCardViewItem(matcher: Matcher<View>) :
    KRecyclerItem<FeaturedArticleCardViewItem>(matcher) {
    val headerTitle by lazy{
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.setName(withParent("Заголовок"))
    }
    val languageCode by lazy{
        KTextView(matcher) {
            withId(R.id.langCodeText)
        }.setName(withParent("Код языка"))
    }
    val imageMenu by lazy{
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.setName(withParent("Кнопка меню"))
    }
    val articleImage by lazy{
        KImageView(matcher) {
            withId(R.id.articleImage)
        }.setName(withParent("Изображение"))
    }
    val articleTitleText by lazy{
        KTextView(matcher) {
            withId(R.id.articleTitle)
        }.setName(withParent("Заголовок"))
    }
    val articleDescriptionText by lazy{
        KTextView(matcher) {
            withId(R.id.articleDescription)
        }.setName(withParent("Описание"))
    }
    val divider by lazy{
        KImageView(matcher) {
            withId(R.id.articleDivider)
        }.setName(withParent("Разделитель"))
    }
    val articleExtractText by lazy{
        KTextView(matcher) {
            withId(R.id.articleExtract)
        }.setName(withParent("Текст топика"))
    }
    val footerArticleButton by lazy{
        KTextView(matcher) {
            withId(R.id.footerActionButton)
        }.setName(withParent("Нижняя кнопка с текстом"))
    }

}