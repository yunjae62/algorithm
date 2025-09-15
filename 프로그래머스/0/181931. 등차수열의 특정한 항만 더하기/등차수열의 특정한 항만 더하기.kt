class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int = included.indices.filter { included[it] }.sumOf { a + it * d }
}