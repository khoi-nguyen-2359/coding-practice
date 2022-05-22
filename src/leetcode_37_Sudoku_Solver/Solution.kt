package leetcode_37_Sudoku_Solver

class Solution {
    private val columns = Array<MutableSet<Char>>(9) { mutableSetOf() }
    private val rows = Array<MutableSet<Char>>(9) { mutableSetOf() }
    private val boxes = Array<MutableSet<Char>>(9) { mutableSetOf() }
    fun solveSudoku(board: Array<CharArray>): Unit {
        for (r in board.indices) {
            for (c in board[r].indices) {
                if (board[r][c] == '.') {
                    continue
                }
                rows[r].add(board[r][c])
                columns[c].add(board[r][c])
                val b = (r / 3) * 3 + (c / 3)
                boxes[b].add(board[r][c])
            }
        }

        val (nextR, nextC) = findNextEmptyCell(board, 0, -1) ?: return
        traverse(board, nextR, nextC)
    }

    private fun findNextEmptyCell(board: Array<CharArray>, r: Int, c: Int): Pair<Int, Int>? {
        var nextR = r
        var nextC = c
        do {
            nextR += (nextC + 1) / 9
            nextC = (nextC + 1) % 9
        } while (nextR < 9 && board[nextR][nextC] != '.')
        if (nextR == 9) {
            return null
        }
        return nextR to nextC
    }

    private fun traverse(board: Array<CharArray>, r: Int, c: Int): Boolean {
        val b = (r / 3) * 3 + (c / 3)
        for (i in '1'..'9') {
            if (columns[c].contains(i) || rows[r].contains(i) || boxes[b].contains(i)) {
                continue
            }
            
            rows[r].add(i)
            columns[c].add(i)
            boxes[b].add(i)
            board[r][c] = i

            val (nextR, nextC) = findNextEmptyCell(board, r, c) ?: return true
            val result = traverse(board, nextR, nextC)
            if (result) {
                return true
            }

            rows[r].remove(i)
            columns[c].remove(i)
            boxes[b].remove(i)
            board[r][c] = '.'
        }
        
        return false
    }
}

fun main() {

}