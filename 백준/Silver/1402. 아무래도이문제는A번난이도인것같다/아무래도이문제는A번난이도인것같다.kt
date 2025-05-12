fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    repeat(T) { readLine() }
    println("yes\n".repeat(T))
}