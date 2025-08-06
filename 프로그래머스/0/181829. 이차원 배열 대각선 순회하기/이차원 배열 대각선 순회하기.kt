class Solution {
    fun solution(board: Array<IntArray>, k: Int): Int = board.indices.sumOf { i ->
        board[i].indices
            .filter { j -> i + j <= k }
            .sumOf { j -> board[i][j] }
    }
}
