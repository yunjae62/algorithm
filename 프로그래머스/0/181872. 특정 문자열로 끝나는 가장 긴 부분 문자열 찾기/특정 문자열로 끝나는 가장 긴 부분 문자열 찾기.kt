class Solution {
    fun solution(myString: String, pat: String): String {
        var answer: String = ""
        for (i in 1..myString.length) {
            val str = myString.substring(0, i)
            if (str.endsWith(pat)) {
                answer = str
            }
        }
        return answer
    }
}