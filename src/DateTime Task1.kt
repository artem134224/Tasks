//1. Основы LocalDate и LocalTime
//Задача: Напишите программу, которая:
//
//Создает объект LocalDate, представляющий текущую дату.
//Создает объект LocalTime, представляющий текущее время.
//Выводит их значения в формате dd-MM-yyyy HH:mm:ss
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun main() {
    val currentDate = LocalDate.now()
    val currentTime = LocalTime.now()
    val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    println("Дата: ${currentDate.format(dateFormatter)}")
    println("Время: ${currentTime.format(timeFormatter)}")
}
