class Solution {
    fun solution(n: Int): IntArray = generateSequence(n) { x ->
        when {
            x == 1 -> null
            x % 2 == 0 -> x / 2
            else -> 3 * x + 1
        }
    }.toList().toIntArray()
}