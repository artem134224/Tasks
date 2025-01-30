//14. Конвертация даты в строку с учетом локали
//Задача: Создайте метод, который принимает объект LocalDate и выводит его в строковом формате с учетом локали, например, ru или en.
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun formatDateByLocale(date: LocalDate, locale: String): String {
    val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale(locale))
    return date.format(formatter)
}

fun main() {
    val date = LocalDate.of(2025, 1, 30)
    println("Дата в формате (ru): ${formatDateByLocale(date, "ru")}")
    println("Дата в формате (en): ${formatDateByLocale(date, "en")}")
}
