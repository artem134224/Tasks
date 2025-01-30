//10. Создание календаря на месяц
//Задача: Напишите метод, который принимает месяц и год и выводит все даты месяца с указанием, является ли каждая из них рабочим днем или выходным.
import java.time.DayOfWeek
import java.time.LocalDate

fun printCalendar(month: Int, year: Int) {
    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth())

    var currentDate = firstDayOfMonth
    while (!currentDate.isAfter(lastDayOfMonth)) {
        val dayOfWeek = currentDate.dayOfWeek
        val isWeekend = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY
        val dayType = if (isWeekend) "выходной" else "рабочий день"
        println("${currentDate} - $dayType")
        currentDate = currentDate.plusDays(1)
    }
}

fun main() {
    val month = 1
    val year = 2025
    printCalendar(month, year)
}
