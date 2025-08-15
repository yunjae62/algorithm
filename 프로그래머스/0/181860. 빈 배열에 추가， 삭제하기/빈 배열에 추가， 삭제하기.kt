class Solution {
    fun solution(arr: IntArray, flag: BooleanArray): IntArray {
        val X = mutableListOf<Int>()
        
        for (i in arr.indices) {
            if (flag[i]) {
                repeat(arr[i] * 2) { X.add(arr[i]) }
            } else {
                repeat(arr[i]) { X.removeAt(X.size - 1) }
            }
        }
        
        return X.toIntArray()
    }
}