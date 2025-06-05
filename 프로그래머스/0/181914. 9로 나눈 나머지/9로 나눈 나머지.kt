class Solution {
    fun solution(number: String): Int = number.sumOf(Char::digitToInt) % 9
}