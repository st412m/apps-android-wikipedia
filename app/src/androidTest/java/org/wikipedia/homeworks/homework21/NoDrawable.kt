package org.wikipedia.homeworks.homework21

import io.github.kakaocup.kakao.common.assertions.BaseAssertions


fun BaseAssertions.noDrawable() {
    view.check(NoDrawableAssertion())
}