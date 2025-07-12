class Solution {
    fun solution(my_string: String): Array<String> = my_string.trim().split("\\s+".toRegex()).toTypedArray();
}