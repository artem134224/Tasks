//Задание 4: Программа с использованием Java NIO
//Задача: Напишите программу, которая копирует файл с использованием Java NIO.
//
//Использовать FileChannel для чтения и записи данных.
//Программа должна поддерживать возможность копирования больших файлов (> 1 Гб).
//Реализовать обработку исключений, связанных с доступом к файлу или его отсутствием.
//Условия:
//
//Используйте методы transferTo() или transferFrom() из FileChannel для копирования содержимого.
//Программа должна быть устойчива к прерыванию работы и сообщать об ошибках.
//Критерии:
//
//Корректная работа с большими файлами.
//Использование механизмов NIO и сравнение производительности с классическим IO (опционально).
import java.io.File
import java.io.IOException
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.nio.file.Path

// Функция для создания файла, если его нет
fun createFileIfNotExists(filePath: String) {
    val file = File(filePath)
    if (!file.exists()) {
        println("Source file does not exist. Creating a new file...")
        file.createNewFile()
        val content = "This is a sample text in source_file.txt.\n"
        file.appendText(content.repeat(1000)) // Заполняем файл данными (1000 строк)
    } else {
        println("Source file already exists.")
    }
}

// Функция для копирования файла с использованием NIO (FileChannel)
fun copyFileUsingNIO(sourcePath: String, destinationPath: String) {
    // Открываем каналы для исходного и целевого файлов
    val sourceFile: Path = Paths.get(sourcePath)
    val destinationFile: Path = Paths.get(destinationPath)

    // Проверка, существует ли исходный файл
    if (!Files.exists(sourceFile)) {
        throw IOException("Source file does not exist: $sourcePath")
    }

    // Создаем или открываем целевой файл
    val destinationDir = destinationFile.parent
    if (destinationDir != null && !Files.exists(destinationDir)) {
        Files.createDirectories(destinationDir)
    }

    // Открываем каналы для исходного и целевого файлов
    FileChannel.open(sourceFile, StandardOpenOption.READ).use { sourceChannel ->
        FileChannel.open(destinationFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE).use { destinationChannel ->

            // Используем transferTo() для копирования данных
            val size = sourceChannel.size()
            sourceChannel.transferTo(0, size, destinationChannel)
        }
    }
}

fun main() {
    val sourceFilePath = "source_file.txt"  // Путь к исходному файлу
    val destinationFilePath = "destination_file.txt"  // Путь к файлу назначения

    // Создаем файл, если его нет
    createFileIfNotExists(sourceFilePath)

    try {
        copyFileUsingNIO(sourceFilePath, destinationFilePath)
        println("File copied successfully from $sourceFilePath to $destinationFilePath")
    } catch (e: IOException) {
        println("Error during file copy: ${e.message}")
    }
}
