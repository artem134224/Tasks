//Задание 1: Работа с потоками ввода-вывода
//Задача: Напишите программу, которая читает текст из файла и записывает его в другой файл с изменениями:
//
//Программа должна читать содержимое исходного файла построчно.
//Преобразовать каждую строку текста в верхний регистр.
//Записать преобразованный текст в новый файл.
//Условия:
//
//Для работы с файлами использовать классы из пакета java.io: BufferedReader, BufferedWriter, FileReader, FileWriter.
//Программа должна быть устойчивой к ошибкам, например, если файл не найден.
//Использовать обработку исключений через try-with-resources.
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

fun main() {
    val inputFile = "input.txt"   // Исходный файл
    val outputFile = "output.txt" // Файл для записи преобразованного текста

    try {
        // Открываем файлы для чтения и записи
        BufferedReader(FileReader(inputFile)).use { reader ->
            BufferedWriter(FileWriter(outputFile)).use { writer ->
                var line: String?

                // Чтение строк из исходного файла и запись в новый файл
                while (reader.readLine().also { line = it } != null) {
                    // Преобразуем строку в верхний регистр и записываем
                    writer.write(line?.uppercase() ?: "")
                    writer.newLine()  // Переход на новую строку
                }
            }
        }

        println("Текст успешно преобразован и записан в $outputFile")

    } catch (e: IOException) {
        println("Ошибка при обработке файлов: ${e.message}")
    }
}
