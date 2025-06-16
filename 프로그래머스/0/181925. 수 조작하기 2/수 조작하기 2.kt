class Solution {
    fun solution(numLog: IntArray): String = buildString {
        for (i in 1 until numLog.size) {
            when (numLog[i] - numLog[i - 1]) {
                1 -> append('w')
                -1 -> append('s')
                10 -> append('d')
                -10 -> append('a')
            }
        }
    }
}