fun main() {
    val n = readln().toInt()
    val dp = IntArray(11)
    dp[2] = 1
    for (i in 3..n) {
        dp[i] = dp[i - 1] + i - 1
    }
    print(dp[n])
}