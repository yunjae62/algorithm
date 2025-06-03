class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        val sb = StringBuilder()
        for (i in 0 until parts.size) {
            sb.append(my_strings[i].substring(parts[i][0], parts[i][1] + 1));
        }
        return sb.toString()
    }
}