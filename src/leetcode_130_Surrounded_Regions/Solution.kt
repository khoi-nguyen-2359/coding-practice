package leetcode_130_Surrounded_Regions

class Solution {
    private val directions = listOf(
            listOf(1, 0),
            listOf(-1, 0),
            listOf(0, 1),
            listOf(0, -1)
    )

    private var n = 0
    private var m = 0

    fun solve(board: Array<CharArray>): Unit {
        /*
        1. fill all 'O's that connect with border to another marker ('*')
         */
        n = board.size
        m = board[0].size
        for (i in 0 until n) {
            if (board[i][0] == 'O') {
                fill(board, i, 0, '*')
            }
            if (board[i][m - 1] == 'O') {
                fill(board, i, m - 1, '*')
            }
        }
        for (j in 0 until m) {
            if (board[0][j] == 'O') {
                fill(board, 0, j, '*')
            }
            if (board[n - 1][j] == 'O') {
                fill(board, n - 1, j, '*')
            }
        }

        /*
        2. restore all '*' and turn all 'O' to 'X'
         */
        for (i in 0 until n) {
            for (j in 0 until m) {
                board[i][j] = when (board[i][j]) {
                    'O' -> 'X'
                    '*' -> 'O'
                    else -> board[i][j]
                }
            }
        }
    }

    private fun fill(board: Array<CharArray>, r: Int, c: Int, des: Char) {
        board[r][c] = des
        for (d in directions) {
            val rNext = r + d[0]
            val cNext = c + d[1]
            if (rNext in board.indices && cNext in board[rNext].indices && board[rNext][cNext] == 'O') {
                fill(board, rNext, cNext, des)
            }
        }
    }
}
