package org.wikipedia.examples

import android.widget.LinearLayout
import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.R
import org.wikipedia.views.AppTextView

val imageViewCentered = KImageView{
    withId(R.id.imageViewCentered)
}

val wikiSlogan = KImageView{
    withText(R.string.onboarding_welcome_title_v2)
    withId(R.id.primaryTextView)
    isInstanceOf(AppTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

fun main(){
    imageViewCentered.isDisplayed()
}