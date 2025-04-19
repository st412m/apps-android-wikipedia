package org.wikipedia.homeworks.homework20

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.tools.setName
import org.wikipedia.homeworks.tools.withParent

class NewFragmentNewsCardItems (matcher: Matcher<View>) : KRecyclerItem<NewFragmentNewsCardItems>(matcher) {

    val newsCardNumber: KView by lazy{
        KView(matcher){
            withId(R.id.view_list_card_number)
        }.setName(withParent("Номер карточки"))
    }

    val newsCardItemTitle: KTextView by lazy{
        KTextView(matcher){
            withId(R.id.view_list_card_item_title)
        }.setName(withParent("Заголовок карточки"))
    }

    val newsCardItemSubtitle: KTextView by lazy{
        KTextView(matcher){
            withId(R.id.view_list_card_item_subtitle)
        }.setName(withParent("Описание карточки"))
    }

    val newsCardItemGraph: KView by  lazy {
        KView(matcher){
            withId(R.id.view_list_card_item_graph)
        }.setName(withParent("Изображение графика"))
    }

    val newsCardItemPageViews: KTextView by lazy{
        KTextView(matcher){
            withId(R.id.view_list_card_item_pageviews)
        }.setName(withParent("Количество просмотров"))
    }

    val newsCardItemImage: KImageView by lazy{
        KImageView(matcher){
            withId(R.id.view_list_card_item_image)
        }.setName(withParent("Картинка карточки"))
    }
}