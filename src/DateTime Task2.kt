//2. Сравнение дат
//Задача: Напишите метод, который принимает две даты (LocalDate) и определяет, какая из них больше, меньше или равна другой. Верните соответствующее сообщение.
import java.time.LocalDate

fun compareDates(date1: LocalDate, date2: LocalDate): String {
    return when {
        date1.isBefore(date2) -> "Первая дата меньше второй"
        date1.isAfter(date2) -> "Первая дата больше второй"
        else -> "Даты равны"
    }
}

fun main() {
    val date1 = LocalDate.of(2025, 1, 30)
    val date2 = LocalDate.of(2025, 2, 1)

    println(compareDates(date1, date2))
}
