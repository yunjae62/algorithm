fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln() }

    var isIncreasing = true
    var isDecreasing = true

    for (i in 0 until n - 1) {
        if (arr[i] >= arr[i + 1]) isIncreasing = false
        if (arr[i] <= arr[i + 1]) isDecreasing = false
        if (!isIncreasing && !isDecreasing) break
    }

    when {
        isIncreasing -> print("INCREASING")
        isDecreasing -> print("DECREASING")
        else -> print("NEITHER")
    }
}
