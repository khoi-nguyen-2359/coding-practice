package leetcode_576_Out_of_Boundary_Paths

import kotlin.test.assertEquals

class SolutionRecursive {
    private val MAX_ANS: Int = 1000000007
    private val directions = arrayOf(
            0 to 1,
            0 to -1,
            1 to 0,
            -1 to 0
    )

    private var m: Int = 0
    private var n: Int = 0
    private lateinit var memo: Array<Array<IntArray>>
    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        if (maxMove == 0) {
            return 0
        }
        this.m = m
        this.n = n
        memo = Array(m) { Array(n) { IntArray(maxMove + 1) { -1 } } }
        return countPaths(startRow, startColumn, maxMove)
    }

    private fun countPaths(row: Int, col: Int, move: Int): Int {
        if (row !in 0 until m || col !in 0 until n) {
            return 1
        }

        if (move <= 0) {
            return 0
        }

        if (memo[row][col][move] != -1) {
            return memo[row][col][move]
        }

        val nextMove = move - 1
        var count: Int = 0
        for ((dr, dc) in directions) {
            val nextRow = row + dr
            val nextCol = col + dc
            count += countPaths(nextRow, nextCol, nextMove) % MAX_ANS
        }

        memo[row][col][move] = count
        return count
    }
}

data class Input(val m: Int, val n: Int, val maxMove: Int, val startRow: Int, val startColumn: Int)

fun main() {
    arrayOf(
            Input(2, 2, 2, 0, 0) to 6,
            Input(1, 3, 3, 0, 1) to 12,
            Input(4, 4, 2, 2, 2) to 2,
            Input(4, 4, 3, 2, 2) to 12,
            Input(3, 8, 1, 2, 0) to 2,
            Input(3, 8, 0, 2, 0) to 0,
            Input(8, 7, 16, 1, 5) to 149,
            Input(2, 3, 8, 1, 0) to 1104,
    ).forEach { (input, exp) ->
        assertEquals(exp, SolutionRecursive().findPaths(input.m, input.n, input.maxMove, input.startRow, input.startColumn), input.toString())
    }
}