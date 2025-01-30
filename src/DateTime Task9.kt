//9. Вычисление возраста по дате рождения
//Задача: Напишите метод, который принимает дату рождения в формате LocalDate и возвращает текущий возраст в годах.
import java.time.LocalDate
import java.time.Period

fun calculateAge(birthDate: LocalDate): Int {
    val currentDate = LocalDate.now()
    val period = Period.between(birthDate, currentDate)
    return period.years
}

fun main() {
    val birthDate = LocalDate.of(1990, 1, 1)
    println("Возраст: ${calculateAge(birthDate)} лет")
}
