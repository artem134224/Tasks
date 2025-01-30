//адание 5: Асинхронное чтение файла с использованием NIO.2
//Задача: Напишите программу, которая выполняет асинхронное чтение файла с использованием NIO.2.
//
//Используйте классы AsynchronousFileChannel и CompletionHandler.
//Программа должна читать файл и выводить его содержимое на консоль по мере чтения.
//Условия:
//
//Файл должен считываться асинхронно в отдельном потоке.
//Реализуйте CompletionHandler для обработки завершения чтения файла и ошибок.
//Критерии:
//
//Правильная работа с асинхронным API.
//Асинхронная обработка завершения операции чтения.
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.nio.channels.CompletionHandler
import java.nio.file.Files
import java.nio.file.FileVisitOption
import java.nio.file.FileVisitResult

fun main() {
    val filePath = "source_file.txt" // Укажите путь к вашему файлу
    val path: Path = Paths.get(filePath)

    // Проверка, существует ли файл
    if (!Files.exists(path)) {
        println("File does not exist: $filePath")
        return
    }

    // Открываем AsynchronousFileChannel для чтения файла
    val asyncFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)

    // Буфер для хранения данных, читаемых из файла
    val buffer = ByteBuffer.allocate(1024)

    // Чтение файла асинхронно
    asyncFileChannel.read(buffer, 0, null, object : CompletionHandler<Int, Void?> {
        override fun completed(result: Int?, attachment: Void?) {
            println("Read $result bytes")
            buffer.flip() // Переводим буфер в режим чтения
            val content = String(buffer.array(), 0, result ?: 0)
            println("File content: \n$content")

            // Продолжаем чтение в случае необходимости
            if (result != null && result > 0) {
                // Продолжаем читать с того места, где остановились
                buffer.clear()
                asyncFileChannel.read(buffer, result.toLong(), null, this)
            } else {
                println("File read completed.")
                asyncFileChannel.close()
            }
        }

        override fun failed(exc: Throwable?, attachment: Void?) {
            println("Error reading file: ${exc?.message}")
            exc?.printStackTrace()
            try {
                asyncFileChannel.close()
            } catch (e: IOException) {
                println("Error closing file channel: ${e.message}")
            }
        }
    })
}
