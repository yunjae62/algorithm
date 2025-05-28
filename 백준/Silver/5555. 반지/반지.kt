fun main() = with(System.`in`.bufferedReader()) {
    var count = 0
    val word = readLine()

    repeat(readLine().toInt()) {
        val input = readLine()
        val ring = input + input.substring(0, input.length - 1)

        if (ring.contains(word)) {
            count++
        }
    }

    print(count)
}