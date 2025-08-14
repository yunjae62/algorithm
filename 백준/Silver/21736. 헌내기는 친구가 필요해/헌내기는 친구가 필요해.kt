import java.util.*

data class Point(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readln().split(' ').map { it.toInt() }
    val graph = Array(N) { readln().toCharArray() }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    var answer = 0

    fun bfs(ox: Int, oy: Int) {
        val q = LinkedList<Point>()
        val visited = Array(N) { BooleanArray(M) }
        visited[ox][oy] = true
        q.add(Point(ox, oy))

        while (q.isNotEmpty()) {
            val now = q.poll()

            if (graph[now.x][now.y] == 'P') {
                answer++;
            }

            for (i in 0..3) {
                val nx = now.x + dx[i]
                val ny = now.y + dy[i]

                if ((nx in 0..<N) && (ny in 0..<M) && (!visited[nx][ny]) && (graph[nx][ny] != 'X')) {
                    visited[nx][ny] = true
                    q.add(Point(nx, ny))
                }
            }
        }
    }

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (graph[i][j] == 'I') {
                bfs(i, j)
            }
        }
    }

    print(if (answer == 0) "TT" else answer)
}
