class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        for (num in num_list) {
            var x = num
            while (x != 1) {
                if (x % 2 == 0) {
                    x /= 2
                } else {
                    x = (x - 1) / 2
                }
                answer++
            }
        }
        return answer
    }
}