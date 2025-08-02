fun main() {
    val arr = listOf(3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1)

    val A = readln()
    val B = readln()

    val list = mutableListOf<Int>()
    for (i in A.indices) {
        list.add(arr[A[i] - 'A'])
        list.add(arr[B[i] - 'A'])
    }

    var current = list
    while (current.size > 2) {
        val next = mutableListOf<Int>()
        for (i in 0 until current.size - 1) {
            next.add((current[i] + current[i + 1]) % 10)
        }
        current = next
    }

    println("${current[0]}${current[1]}")
}
