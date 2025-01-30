//Задача 2.
//Логирование в системе:
//Создайте класс для системы логирования, который реализует паттерн Singleton. Класс должен сохранять все сообщения логов в список и предоставлять метод для их вывода.
//Требования:
//Класс должен быть Singleton.
//Реализуйте метод для добавления сообщений в логи.
//Реализуйте метод для вывода всех логов.
class Logger private constructor() {

    private val logMessages: MutableList<String> = mutableListOf()

    // Метод для добавления сообщения в логи
    fun log(message: String) {
        logMessages.add(message)
    }

    // Метод для вывода всех логов
    fun printLogs() {
        if (logMessages.isEmpty()) {
            println("Логи пусты.")
        } else {
            logMessages.forEach { println(it) }
        }
    }

    companion object {
        @Volatile
        private var instance: Logger? = null

        // Метод для получения экземпляра Logger
        fun getInstance(): Logger {
            return instance ?: synchronized(this) {
                instance ?: Logger().also { instance = it }
            }
        }
    }
}

fun main() {
    val logger = Logger.getInstance()

    logger.log("Программа запущена.")
    logger.log("Пользователь вошел в систему.")
    logger.log("Произошла ошибка при загрузке данных.")

    println("Все логи:")
    logger.printLogs()

    val anotherLogger = Logger.getInstance()
    println("logger и anotherLogger ссылаются на один и тот же объект: ${logger === anotherLogger}")
}
