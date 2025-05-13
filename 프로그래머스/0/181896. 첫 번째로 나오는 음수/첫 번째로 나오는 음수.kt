class Solution {
    fun solution(num_list: IntArray): Int {
        for ((index, num) in num_list.withIndex()) {
            if (num < 0) {
                return index
            }
        }
        
        return -1
    }
}