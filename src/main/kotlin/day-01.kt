import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val input = Files.readString(Path.of("input/01.txt"))

    // val counts = input
    //     .groupBy { it }
    //     .map { it.value.size}
    // val result = counts[0] - counts[1]
    // println(result)

    var floor = 0
    var result = 0
    for (index in input.indices) {
        floor += if (input[index] == '(') 1 else -1
        if (floor == -1) {
            result = index+1
            break
        }
    }
    println(result)
}