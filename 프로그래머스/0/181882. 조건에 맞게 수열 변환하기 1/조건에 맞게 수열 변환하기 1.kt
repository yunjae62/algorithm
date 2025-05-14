class Solution {
    fun solution(arr: IntArray): IntArray {
        return arr.map {
            when {
                it >= 50 && it % 2 == 0 -> it / 2
                it < 50 && it % 2 == 1 -> it * 2
                else -> it
            }
        }.toIntArray()
    }
}