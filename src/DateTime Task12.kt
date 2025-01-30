//12. Расчет времени до заданной даты
//Задача: Создайте метод, который принимает дату и время события и рассчитывает, сколько часов, минут и секунд осталось до него от текущего момента.
import java.time.LocalDateTime
import java.time.Duration

fun timeUntilEvent(eventDateTime: LocalDateTime): String {
    val currentDateTime = LocalDateTime.now()
    val duration = Duration.between(currentDateTime, eventDateTime)

    val hours = duration.toHours()
    val minutes = duration.toMinutes() % 60
    val seconds = duration.seconds % 60

    return "$hours часов, $minutes минут, $seconds секунд"
}

fun main() {
    val eventDateTime = LocalDateTime.of(2025, 12, 31, 23, 59, 59)
    println("До события осталось: ${timeUntilEvent(eventDateTime)}")
}
