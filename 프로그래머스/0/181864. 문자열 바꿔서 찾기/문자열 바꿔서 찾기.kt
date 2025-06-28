class Solution {
    fun solution(myString: String, pat: String): Int = if (myString.replace('A', 'b').replace('B', 'A').replace('b', 'B').contains(pat)) 1 else 0
}
