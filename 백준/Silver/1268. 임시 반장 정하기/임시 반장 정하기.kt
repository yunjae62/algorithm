fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = Array(N) { readLine().split(" ").map(String::toInt).toIntArray() }
    val visited = Array(N) { BooleanArray(N) }
    val friends = IntArray(N)

    for (grade in 0 until 5) {
        val buckets = mutableMapOf<Int, MutableList<Int>>()
        for (stu in 0 until N) {
            buckets.getOrPut(arr[stu][grade]) { mutableListOf() }.add(stu)
        }
        for (group in buckets.values) {
            for (i in 0 until group.size) {
                for (j in i + 1 until group.size) {
                    val a = group[i]
                    val b = group[j]
                    if (!visited[a][b]) {
                        visited[a][b] = true
                        visited[b][a] = true
                        friends[a]++
                        friends[b]++
                    }
                }
            }
        }
    }

    val maxF = friends.maxOrNull() ?: 0
    println(friends.indexOfFirst { it == maxF } + 1)
}
