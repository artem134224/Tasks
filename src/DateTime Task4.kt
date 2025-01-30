//4. Проверка високосного года
//Задача: Реализуйте метод, который принимает год и возвращает true, если он является високосным, и false в противном случае.
fun isLeapYear(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}

fun main() {
    val year = 2025
    println("Год $year является високосным: ${isLeapYear(year)}")
}
