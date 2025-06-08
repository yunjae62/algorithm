class Solution {
    fun solution(my_string: String, index_list: IntArray) = buildString(index_list.size) { index_list.forEach { append(my_string[it]) } }
}