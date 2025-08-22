class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for ((i, j) in queries) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
        return arr
    }
}