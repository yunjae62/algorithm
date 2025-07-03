class Solution {
    fun solution(n: Int): Array<IntArray> {
        val arr = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            arr[i][i] = 1
        }
        return arr
    }
}