//Задание 2: Реализация паттерна Декоратор
//Задача: Реализуйте паттерн Декоратор для обработки текста. Напишите набор классов, которые будут декорировать строку:
//
//Основной интерфейс TextProcessor, содержащий метод process(String text).
//Реализуйте класс SimpleTextProcessor, который просто возвращает текст без изменений.
//Реализуйте декораторы:
//UpperCaseDecorator — преобразует текст в верхний регистр.
//TrimDecorator — удаляет пробелы в начале и конце строки.
//ReplaceDecorator — заменяет все пробелы символом подчеркивания (_).
//Условия:
//
//Продемонстрируйте работу декораторов, комбинируя их.
//Пример использования: оберните текст в несколько декораторов и вызовите process.

// Интерфейс TextProcessor
interface TextProcessor {
    fun process(text: String): String
}

// Класс SimpleTextProcessor — возвращает текст без изменений
class SimpleTextProcessor : TextProcessor {
    override fun process(text: String): String {
        return text
    }
}

// Декоратор UpperCaseDecorator — преобразует текст в верхний регистр
class UpperCaseDecorator(private val textProcessor: TextProcessor) : TextProcessor {
    override fun process(text: String): String {
        return textProcessor.process(text).uppercase() // Используем uppercase() вместо toUpperCase()
    }
}

// Декоратор TrimDecorator — удаляет пробелы в начале и конце строки
class TrimDecorator(private val textProcessor: TextProcessor) : TextProcessor {
    override fun process(text: String): String {
        return textProcessor.process(text).trim()
    }
}

// Декоратор ReplaceDecorator — заменяет все пробелы на символ подчеркивания
class ReplaceDecorator(private val textProcessor: TextProcessor) : TextProcessor {
    override fun process(text: String): String {
        return textProcessor.process(text).replace(" ", "_")
    }
}

// Демонстрация работы декораторов
fun main() {
    val simpleProcessor = SimpleTextProcessor()

    // Применение нескольких декораторов
    val upperCaseProcessor = UpperCaseDecorator(simpleProcessor)
    val trimProcessor = TrimDecorator(upperCaseProcessor)
    val replaceProcessor = ReplaceDecorator(trimProcessor)

    val text = "  Hello World from Kotlin!  "

    // Обработка текста
    println("Original Text: \"$text\"")
    println("Processed Text: \"${replaceProcessor.process(text)}\"")
}
