import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val graph = Array(N) { IntArray(M) }
    val virusList = mutableListOf<Pair<Int, Int>>()

    repeat(N) { i ->
        st = StringTokenizer(br.readLine())

        repeat(M) { j ->
            graph[i][j] = st.nextToken().toInt()
            if (graph[i][j] == 2) {
                virusList += Pair(i, j)
            }
        }
    }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    var answer = 0

    fun dfs(depth: Int) {
        if (depth == 3) {
            val temp = Array(N) { i -> graph[i].clone() }
            val q = ArrayDeque<Pair<Int, Int>>()
            virusList.forEach { q += it }

            while (q.isNotEmpty()) {
                val (x, y) = q.removeFirst()
                for (dir in 0..3) {
                    val nx = x + dx[dir]
                    val ny = y + dy[dir]
                    if (nx in 0 until N && ny in 0 until M && temp[nx][ny] == 0) {
                        temp[nx][ny] = 2
                        q += Pair(nx, ny)
                    }
                }
            }

            var safe = 0
            for (i in 0 until N) {
                for (j in 0 until M) {
                    if (temp[i][j] == 0) safe++
                }
            }
            answer = maxOf(answer, safe)
            return
        }

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1
                    dfs(depth + 1)
                    graph[i][j] = 0
                }
            }
        }
    }

    dfs(0)
    println(answer)
}
