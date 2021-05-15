import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val input = Files.readString(Path.of("input/01.txt"))
    val counts = input
        .groupBy { it }
        .map { it.value.size}
    val result = counts[0] - counts[1]
    println(result)
}