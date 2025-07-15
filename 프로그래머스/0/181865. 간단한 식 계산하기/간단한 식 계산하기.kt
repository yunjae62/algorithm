class Solution {
    fun solution(binomial: String): Int {
        val (a, op, b) = binomial.split(" ")
        return when(op) {
            "+" -> a.toInt() + b.toInt()
            "-" -> a.toInt() - b.toInt()
            else -> a.toInt() * b.toInt()
        }
    }
}