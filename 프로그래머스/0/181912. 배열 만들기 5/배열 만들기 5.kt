class Solution {
    fun solution(intStrs: Array<String>, k: Int, s: Int, l: Int): IntArray {
        var answer = mutableListOf<Int>()
        for (str in intStrs) {
            val n = str.substring(s, s + l).toInt()
            if (n > k) {
                answer.add(n)
            }
        }
        return answer.toIntArray()
    }
}