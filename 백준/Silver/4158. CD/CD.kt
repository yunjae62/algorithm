fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        if (N == 0 && M == 0) break

        val set = buildSet { repeat(N) { add(readLine().toInt()) } }
        val count = (1..M).count { readLine().toInt() in set }

        sb.appendLine(count)
    }

    print(sb)
}