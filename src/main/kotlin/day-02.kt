import java.nio.file.Files
import java.nio.file.Path

data class Present(val length: Int, val width: Int, val height: Int) {
    fun computeWrappingPaperLength(): Int {
        val areaOfSides = listOf(
            length * width,
            length * height,
            width * height
        )
        val smallestSide = areaOfSides.minOrNull()
        return 2 * length * width + 2 * width * height + 2 * height * length +
            (smallestSide ?: throw IllegalStateException("Minimum side not found"))
    }

    fun shortestPerimeter(): Int {
        val perimeters = listOf(
            2 * length + 2 * width,
            2 * length + 2 * height,
            2 * width + 2 * height
        )
        val smallestPerimeter = perimeters.minOrNull()
        return smallestPerimeter ?: throw IllegalStateException("Minimum perimeter not found")
    }
}

fun main() {
    val lines = Files.readAllLines(Path.of("input/02.txt"))
    val presents = lines.map {
        val parts = it.split("x").map { side -> side.toInt() }
        Present(parts[0], parts[1], parts[2])
    }

    // val paperLengths = presents.map { it.computeWrappingPaperLength() }
    // val result = paperLengths.sum()
    // println(result)

    val result = presents.sumOf {
        val ribbon = it.shortestPerimeter()
        val bow = it.width * it.height * it.length
        ribbon + bow
    }
    println(result)
}