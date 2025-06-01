class Solution {
    fun solution(my_string: String): Array<String> {
        val answer = Array(my_string.length) { my_string.substring(it) }
        answer.sort()
        return answer
    }
}