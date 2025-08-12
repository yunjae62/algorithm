class Solution {
    fun solution(my_string: String, indices: IntArray): String {
        val removes = indices.toHashSet()
        val sb = StringBuilder(my_string.length - removes.size)
        for (i in my_string.indices) {
            if (i !in removes) sb.append(my_string[i])
        }
        return sb.toString()
    }
}
