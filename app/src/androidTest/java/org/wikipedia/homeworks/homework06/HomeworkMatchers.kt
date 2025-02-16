package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.TypeSafeMatcher

enum class Color { RED, BLUE, GREEN, YELLOW, BLACK, WHITE }

data class Shape(val length: Float, val numberOfSides: Int, val color: Color)

class LengthInRange(
    private val min: Float,
    private val max: Float,
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("The length must be in the range between $min and $max")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.length in min..max
    }
}


class TheNumberOfAngles : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("The number of sides should be valid: 0 for a point, 1-2 for a line, 3 or more for a polygon")
    }

    override fun matchesSafely(item: Shape?): Boolean {
        return item?.let { shape ->
            when {
                shape.numberOfSides >= 3 -> true
                shape.numberOfSides in 1..2 -> true
                else -> false
            }
        } ?: false
    }
}

class EvenNumberOfSides : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("The number of sides must be even")
    }

    override fun matchesSafely(item: Shape?): Boolean {
        return item?.numberOfSides?.rem(2) == 0
    }
}

class ShapeColor(
    private val expectedColor: Color,
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("The color must match the $expectedColor")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.color == expectedColor
    }
}

class NegativeLengthOfSides : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("The length of a side cannot be negative.")
    }

    override fun matchesSafely(item: Shape?): Boolean {
        return item?.length?.let { length ->
            length >= 0
        } ?: false
    }
}


class NegativeNumberOfSides : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("The number of sides cannot be negative.")
    }

    override fun matchesSafely(item: Shape?): Boolean {
        return item?.numberOfSides?.let { sides ->
            sides >= 0
        } ?: false
    }
}

class GeneralMatcher(){
    val allOfMatchers = mutableListOf<Matcher<Shape>>()
    operator fun invoke(function: GeneralMatcher.() -> Unit){
        function()
    }
    fun CheckLengthInRange(min: Float, max: Float){
        allOfMatchers.add(LengthInRange(min, max))
    }
    fun CheckTheNumberOfAngles(){
        allOfMatchers.add(TheNumberOfAngles())
    }
    fun CheckEvenNumberOfSides(){
        allOfMatchers.add(EvenNumberOfSides())
    }
    fun CheckShapeColor(expectedColor: Color){
        allOfMatchers.add(ShapeColor(expectedColor))
    }
    fun CheckNegativeLengthOfSides(){
        allOfMatchers.add(NegativeLengthOfSides())
    }
    fun CheckNegativeNumberOfSides(){
        allOfMatchers.add(NegativeNumberOfSides())
    }
    fun CollectAllMatchersAllOf() = allOf(allOfMatchers)
    fun CollectAllMatchersAnyOf() = anyOf(allOfMatchers)

}

fun main(){
    val shapes = listOf(
        Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
    )

    val generalMatcher = GeneralMatcher()

    generalMatcher {
        CheckLengthInRange(0f, 30f)
        CheckTheNumberOfAngles()
        CheckNegativeLengthOfSides()
        CheckNegativeNumberOfSides()
        CheckShapeColor(Color.YELLOW)
        CheckEvenNumberOfSides()
    }

    val result = shapes.filter { generalMatcher.CollectAllMatchersAllOf().matches(it) }
    println(result)
    val result1 = shapes.filter { generalMatcher.CollectAllMatchersAnyOf().matches(it) }
    println(result1)

    val matcher = generalMatcher.CollectAllMatchersAllOf()

    shapes.forEachIndexed { index, shape ->
        val result = matcher.matches(shape)
        println("Фигура ${index + 1}: длина=${shape.length}, стороны=${shape.numberOfSides}, цвет=${shape.color}")
        println("Результат проверки: ${if (result) "ПРОШЛА" else "НЕ ПРОШЛА"}\n")
    }

    shapes.forEachIndexed { index, shape ->
        try {
            val generalMatcher = GeneralMatcher()
            generalMatcher {
                CheckLengthInRange(0f, 30f)
                CheckTheNumberOfAngles()
                CheckNegativeLengthOfSides()
                CheckNegativeNumberOfSides()
                CheckShapeColor(Color.YELLOW)
                CheckEvenNumberOfSides()
            }

            assertThat("При проверке фигуры ${index + 1}\n обнаружены несоответствия", shape, generalMatcher
                .CollectAllMatchersAllOf())
            println("Фигура ${index + 1} прошла все проверки")

        } catch (e: AssertionError) {
            println("Фигура ${index + 1} не прошла проверки: ${e.message}")
        }
    }
}