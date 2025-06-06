class Solution {
    fun solution(num_list: IntArray): Int {
        var odd = 0
        var even = 0
        
        num_list.forEach {
            if (it % 2 == 0) {
                even = even * 10 + it
            } else {
                odd = odd * 10 + it
            }
        }
        
        return odd + even
    }
}