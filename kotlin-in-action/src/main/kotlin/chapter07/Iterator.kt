package chapter07

import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> =
    object : Iterator<LocalDate> {

        var current = start

        override fun hasNext() = current <= endInclusive

        override fun next() = current.apply {
            current = plusDays(1)
        }
    }

fun main() {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysoff = newYear.minusDays(1)..newYear
    for(dayoff in daysoff) { println(dayoff) }
}