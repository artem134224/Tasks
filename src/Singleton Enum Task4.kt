//Задача 4.
//Сезоны года:
//Создайте Enum, представляющий времена года: WINTER, SPRING, SUMMER, AUTUMN. Затем реализуйте функцию, которая принимает значение этого Enum и возвращает соответствующее название сезона на русском языке.
//
//Требования:
//
//Определите Enum для сезонов.
//Реализуйте метод, который принимает сезон и возвращает строку с его названием.
// Определение Enum для сезонов года
enum class Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}

// Функция для получения названия сезона на русском языке
fun getSeasonNameInRussian(season: Season): String {
    return when (season) {
        Season.WINTER -> "Зима"
        Season.SPRING -> "Весна"
        Season.SUMMER -> "Лето"
        Season.AUTUMN -> "Осень"
    }
}

fun main() {
    val season = Season.SUMMER
    println("Название сезона на русском: ${getSeasonNameInRussian(season)}")
}
