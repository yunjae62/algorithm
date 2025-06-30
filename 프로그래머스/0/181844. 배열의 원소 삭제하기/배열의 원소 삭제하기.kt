class Solution {
    fun solution(arr: IntArray, delete_list: IntArray): IntArray = arr.filterNot { it in delete_list.toSet() }.toIntArray()
}