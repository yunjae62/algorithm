class Solution {
    fun solution(n: Int, k: Int): IntArray = IntArray(n / k) { (it + 1) * k }
}
