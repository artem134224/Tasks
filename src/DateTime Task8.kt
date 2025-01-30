//8. Конвертация между часовыми поясами
//Задача: Напишите метод, который принимает дату и время в часовом поясе UTC и конвертирует его в другой часовой пояс, например, Europe/Moscow.
import java.time.ZonedDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun convertTimeZone(utcDateTime: String, targetZone: String): String {
    val utcFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val utcZonedDateTime = ZonedDateTime.parse(utcDateTime, utcFormatter.withZone(ZoneId.of("UTC")))
    val targetZoneDateTime = utcZonedDateTime.withZoneSameInstant(ZoneId.of(targetZone))

    return targetZoneDateTime.format(utcFormatter)
}

fun main() {
    val utcDateTime = "2025-01-30 12:00:00"
    val targetZone = "Europe/Moscow"
    println("Converted Time: ${convertTimeZone(utcDateTime, targetZone)}")
}
