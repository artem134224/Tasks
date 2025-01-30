//3. Сколько дней до Нового года?
//Задача: Создайте метод, который определяет количество дней до Нового года от текущей даты.
import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun daysUntilNewYear(): Long {
    val currentDate = LocalDate.now()
    val newYear = LocalDate.of(2025, 1, 1)
    return ChronoUnit.DAYS.between(currentDate, newYear)
}

fun main() {
    val days = daysUntilNewYear()
    if (days >= 0) {
        println("Дней до Нового года: $days")
    } else {
        println("Новый год уже прошел.")
    }
}
