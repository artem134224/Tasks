//15. Определение дня недели по дате
//Задача: Напишите метод, который принимает дату и возвращает название дня недели на русском языке.
import java.time.LocalDate
import java.util.*

fun getDayOfWeekInRussian(date: LocalDate): String {
    val daysOfWeek = listOf(
        "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"
    )
    return daysOfWeek[date.dayOfWeek.ordinal]
}

fun main() {
    val date = LocalDate.of(2025, 1, 30)
    println("День недели: ${getDayOfWeekInRussian(date)}")
}
