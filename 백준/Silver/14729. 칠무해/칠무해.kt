fun main() = with(System.`in`.bufferedReader()) {
    val scores = DoubleArray(readLine().toInt()) { readLine().toDouble() }
    scores.sort()
    print(buildString { repeat(7) { appendLine(String.format("%.3f", scores[it])) } })
}