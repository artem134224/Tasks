//6. Расчет времени выполнения метода
//Задача: Реализуйте метод, который измеряет время выполнения другого метода (например, цикла из 1 миллиона итераций).
fun measureExecutionTime(method: () -> Unit): Long {
    val startTime = System.nanoTime()
    method()
    val endTime = System.nanoTime()
    return endTime - startTime
}

fun exampleMethod() {
    var sum = 0
    for (i in 1..1_000_000) {
        sum += i
    }
}

fun main() {
    val executionTime = measureExecutionTime { exampleMethod() }
    println("Время выполнения метода: ${executionTime / 1_000_000} мс")
}
