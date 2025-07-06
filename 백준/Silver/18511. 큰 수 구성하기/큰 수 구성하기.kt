import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (N, K) = readLine().split(' ').map { it.toInt() }
    val arr = readLine().split(' ').map { it.toInt() }
    var answer = 0

    fun dfs(depth: Int, maxDepth: Int, num: String) {
        if (depth == maxDepth) {
            val total = num.toInt()
            if (total <= N) {
                answer = max(answer, total)
            }
            return
        }

        for (next in arr) {
            dfs(depth + 1, maxDepth, num + next)
        }
    }

    for (i in 1..N.toString().length) {
        dfs(0, i, "")
    }

    print(answer)
}