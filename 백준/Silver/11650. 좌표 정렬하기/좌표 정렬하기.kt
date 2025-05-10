data class Point(val x: Int, val y: Int) : Comparable<Point> {
    override fun compareTo(other: Point): Int = if (x != other.x) x - other.x else y - other.y
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val points = List(n) {
        readLine()
            .split(' ')
            .map(String::toInt)
            .let { (x, y) -> Point(x, y) }
    }.sorted()

    print(buildString {
        for ((x, y) in points) {
            append(x).append(' ').append(y).appendLine()
        }
    })
}
