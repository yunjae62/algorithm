fun main() {
    val n = readln().toInt()
    var maxList = emptyList<Int>()

    for (i in 1..n) {
        val list = solve(n, i)
        if (list.size > maxList.size) {
            maxList = list
        }
    }

    println(maxList.size)
    println(maxList.joinToString(" "))
}

private fun solve(n: Int, m: Int): List<Int> {
    val list = mutableListOf(n, m)
    var first = n
    var second = m

    while (first - second >= 0) {
        val third = first - second
        list += third
        first = second
        second = third
    }

    return list
}
