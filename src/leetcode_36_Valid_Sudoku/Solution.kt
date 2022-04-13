package leetcode_36_Valid_Sudoku

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val columnChecks = Array<MutableSet<Int>>(9) { mutableSetOf() }
        val rowChecks = Array<MutableSet<Int>>(9) { mutableSetOf() }
        val cellChecks = Array<MutableSet<Int>>(9) { mutableSetOf() }
        for (i in 0..8) {
            for (j in 0..8) {
                val c = (i / 3) * 3 + (j / 3)
                if (board[i][j].isDigit()) {
                    val digit = board[i][j] - '0'
                    if (rowChecks[i].contains(digit) || columnChecks[j].contains(digit) || cellChecks[c].contains(digit)) {
                        return false
                    }
                    rowChecks[i].add(digit)
                    columnChecks[j].add(digit)
                    cellChecks[c].add(digit)
                }
            }
        }

        return true
    }
}