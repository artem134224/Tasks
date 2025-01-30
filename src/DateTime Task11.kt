//11. Генерация случайной даты в диапазоне
//Задача: Реализуйте метод, который принимает две даты и генерирует случайную дату в этом диапазоне.
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.random.Random

fun generateRandomDate(startDate: LocalDate, endDate: LocalDate): LocalDate {
    val daysBetween = ChronoUnit.DAYS.between(startDate, endDate)
    val randomDays = Random.nextLong(daysBetween)
    return startDate.plusDays(randomDays)
}

fun main() {
    val startDate = LocalDate.of(2020, 1, 1)
    val endDate = LocalDate.of(2025, 12, 31)
    val randomDate = generateRandomDate(startDate, endDate)
    println("Случайная дата: $randomDate")
}
