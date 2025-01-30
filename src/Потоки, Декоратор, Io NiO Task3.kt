//Задание 3: Сравнение производительности IO и NIO
//Задача: Напишите программу, которая читает большой текстовый файл (например, несколько мегабайт) двумя способами:
//
//С использованием стандартных классов IO (FileReader и BufferedReader).
//С использованием NIO (классы FileChannel, ByteBuffer, Files).
//Условия:
//
//Измерьте время выполнения каждой операции (чтение и запись файла).
//Выведите результаты на консоль для сравнения производительности.
//Критерии:
//
//Программа должна читать файл целиком и записывать его в другой файл.
//Время выполнения каждого метода должно быть замерено с помощью System.currentTimeMillis() или System.nanoTime().
//Сделайте выводы на основе полученных данных: какой метод быстрее для больших файлов и почему.
import java.io.*
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val inputFile = "large_input.txt"  // Исходный файл
    val outputFileIO = "output_io.txt"  // Файл для записи с использованием IO
    val outputFileNIO = "output_nio.txt"  // Файл для записи с использованием NIO

    // Сначала создадим большой текстовый файл для тестирования (если его нет)
    createLargeFile(inputFile)

    // Измеряем время для метода IO
    val ioStartTime = System.nanoTime()
    readAndWriteUsingIO(inputFile, outputFileIO)
    val ioEndTime = System.nanoTime()
    val ioDuration = ioEndTime - ioStartTime

    // Измеряем время для метода NIO
    val nioStartTime = System.nanoTime()
    readAndWriteUsingNIO(inputFile, outputFileNIO)
    val nioEndTime = System.nanoTime()
    val nioDuration = nioEndTime - nioStartTime

    // Выводим результаты
    println("Time taken using IO (FileReader + BufferedReader): ${ioDuration / 1_000_000} ms")
    println("Time taken using NIO (FileChannel + ByteBuffer): ${nioDuration / 1_000_000} ms")
}

// Метод для создания большого файла для тестирования
fun createLargeFile(fileName: String) {
    val file = File(fileName)
    if (!file.exists()) {
        file.createNewFile()
        val writer = BufferedWriter(FileWriter(file))
        repeat(100000) {  // Создаем примерно 10 Мб данных
            writer.write("This is a test line number $it\n")
        }
        writer.close()
        println("File created: $fileName")
    }
}

// Метод для чтения и записи файла с использованием IO (FileReader и BufferedReader)
fun readAndWriteUsingIO(inputFile: String, outputFile: String) {
    val reader = BufferedReader(FileReader(inputFile))
    val writer = BufferedWriter(FileWriter(outputFile))

    var line: String?
    while (reader.readLine().also { line = it } != null) {
        writer.write(line)
        writer.newLine()
    }
    reader.close()
    writer.close()
}

// Метод для чтения и записи файла с использованием NIO (FileChannel и ByteBuffer)
fun readAndWriteUsingNIO(inputFile: String, outputFile: String) {
    val inputPath = Paths.get(inputFile)
    val outputPath = Paths.get(outputFile)

    // Открываем файл для чтения
    val inputChannel = FileChannel.open(inputPath)
    // Открываем файл для записи
    val outputChannel = FileChannel.open(outputPath, java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.WRITE)

    val buffer = ByteBuffer.allocate(1024)

    while (inputChannel.read(buffer) != -1) {
        buffer.flip()
        outputChannel.write(buffer)
        buffer.clear()
    }
    inputChannel.close()
    outputChannel.close()
}
