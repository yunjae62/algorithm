class Solution {
    fun solution(n: Int, control: String): Int = n + control.sumOf {
        when (it) {
            'w' -> 1
            's' -> -1
            'd' -> 10
            'a' -> -10
            else -> 0
        }.toInt()
    }
}
