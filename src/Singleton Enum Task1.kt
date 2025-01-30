//Задача 1.
//Создание класса базы данных:
//Реализуйте класс, который будет представлять подключение к базе данных. Класс должен быть реализован как Singleton, чтобы при каждом обращении возвращался один и тот же объект.
//Требования:
//Класс должен быть Singleton.
//Метод подключения должен выводить сообщение о создании подключения.
//Проверьте, что при создании нескольких экземпляров — они ссылаются на один и тот же объект.
class DatabaseConnection private constructor() {

    init {
        println("Создано подключение к базе данных.")
    }

    companion object {
        // Ленивая инициализация с потокобезопасностью
        @Volatile
        private var instance: DatabaseConnection? = null

        fun getInstance(): DatabaseConnection {
            return instance ?: synchronized(this) {
                instance ?: DatabaseConnection().also { instance = it }
            }
        }
    }

    fun connect() {
        println("Подключение к базе данных установлено.")
    }
}

fun main() {
    // Проверка, что при создании нескольких экземпляров создается один и тот же объект
    val db1 = DatabaseConnection.getInstance()
    val db2 = DatabaseConnection.getInstance()

    db1.connect()

    println("db1 и db2 ссылаются на один и тот же объект: ${db1 === db2}")
}
