class Solution {
    fun solution(myString: String, pat: String): Int {
        var answer: Int = 0
        
        for (i in 0..myString.length - pat.length) {
            val str = myString.substring(i, i + pat.length)
            if (str.equals(pat)) {
                answer += 1
            }
        }
        
        return answer
    }
}