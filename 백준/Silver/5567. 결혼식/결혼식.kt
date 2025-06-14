fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val M = readLine().toInt()
    val graph = List(N + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(N + 1)
    var count = 0

    visited[1] = true
    val friends = mutableListOf<Int>()

    repeat(M) {
        val (a, b) = readLine().split(" ").map(String::toInt)
        graph[a].add(b)
        graph[b].add(a)
    }

    for (friend in graph[1]) {
        friends += friend
        visited[friend] = true
        count++
    }

    for (friend in friends) {
        for (friendOfFriend in graph[friend]) {
            if (!visited[friendOfFriend]) {
                visited[friendOfFriend] = true
                count++
            }
        }
    }

    print(count)
}