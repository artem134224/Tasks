//7. Форматирование и парсинг даты
//Задача: Напишите программу, которая принимает строку даты в формате dd-MM-yyyy, конвертирует ее в объект LocalDate, добавляет к ней 10 дней и выводит результат в формате yyyy/MM/dd.
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val dateString = "30-01-2025"
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    val date = LocalDate.parse(dateString, formatter)
    val newDate = date.plusDays(10)

    val outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
    println(newDate.format(outputFormatter))
}
