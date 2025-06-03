fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map(String::toInt)
    val arr = Array(101) { IntArray(101) }

    repeat(N) {
        val (x1, y1, x2, y2) = readLine().split(" ").map(String::toInt)
        for (i in x1..x2) {
            for (j in y1..y2) {
                arr[i][j]++
            }
        }
    }

    val count = arr.sumOf { row -> row.count { it > M } }
    print(count)
}