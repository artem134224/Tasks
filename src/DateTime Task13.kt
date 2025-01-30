//13. Вычисление количества рабочих часов
//Задача: Напишите метод, который принимает два объекта LocalDateTime, представляющие начало и конец рабочего дня, и возвращает количество рабочих часов (без учета выходных).
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime

fun calculateWorkHours(start: LocalDateTime, end: LocalDateTime): Long {
    var totalDuration = Duration.ZERO
    var current = start

    while (current.isBefore(end)) {
        if (current.dayOfWeek != DayOfWeek.SATURDAY && current.dayOfWeek != DayOfWeek.SUNDAY) {
            val nextDay = current.plusDays(1).toLocalDate().atStartOfDay()
            val nextTime = if (nextDay.isBefore(end.toLocalDate().atStartOfDay())) nextDay else end

            val duration = Duration.between(current, nextTime)
            totalDuration = totalDuration.plus(duration)
        }
        current = current.plusDays(1)
    }

    return totalDuration.toHours()
}

fun main() {
    val start = LocalDateTime.of(2025, 1, 1, 9, 0, 0)  // Начало рабочего дня
    val end = LocalDateTime.of(2025, 1, 3, 18, 0, 0)   // Конец рабочего дня
    println("Количество рабочих часов: ${calculateWorkHours(start, end)}")
}
