import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val (A, B) = readLine().split(" ").map(String::toInt)
    val N = readLine().toInt()
    var min = abs(A - B)
    repeat(N) {
        val dist = abs(readLine().toInt() - B) + 1
        if (dist < min) {
            min = dist
        }
    }
    print(min)
}