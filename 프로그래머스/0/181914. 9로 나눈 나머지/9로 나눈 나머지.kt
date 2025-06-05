class Solution {
    fun solution(number: String): Int = number.sumOf { it.digitToInt() } % 9
}