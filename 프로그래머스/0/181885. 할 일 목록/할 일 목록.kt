class Solution {
    fun solution(todoList: Array<String>, finished: BooleanArray): Array<String> {
        return todoList
            .filterIndexed { index, _ -> !finished[index] }
            .toTypedArray()
    }
}
