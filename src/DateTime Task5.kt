//5. Подсчет выходных за месяц
//Задача: Напишите метод, который принимает месяц и год и возвращает количество выходных (суббот и воскресений) в этом месяце.
import java.time.DayOfWeek
import java.time.LocalDate

fun countWeekends(month: Int, year: Int): Int {
    var weekendCount = 0
    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth())

    var currentDate = firstDayOfMonth
    while (!currentDate.isAfter(lastDayOfMonth)) {
        if (currentDate.dayOfWeek == DayOfWeek.SATURDAY || currentDate.dayOfWeek == DayOfWeek.SUNDAY) {
            weekendCount++
        }
        currentDate = currentDate.plusDays(1)
    }

    return weekendCount
}

fun main() {
    val month = 1
    val year = 2025
    println("Количество выходных в $month/$year: ${countWeekends(month, year)}")
}
