class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for (query in queries) {
            val s = query[0]
            val e = query[1]
            
            for (i in s..e) {
                arr[i] += 1
            }
        }
        return arr
    }
}