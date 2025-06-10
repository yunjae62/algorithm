fun main() = with(System.`in`.bufferedReader()) {
    val (N, game) = readLine().split(" ")
    val uniquePeople = buildSet { repeat(N.toInt()) { add(readLine()) } }.size
    val groupSize = when (game) {
        "Y" -> 2
        "F" -> 3
        "O" -> 4
        else -> error("no")
    } - 1
    print(uniquePeople / groupSize)
}
