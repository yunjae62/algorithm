class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray = intervals.flatMap { (start, end) -> arr.slice(start..end) }.toIntArray()
}
