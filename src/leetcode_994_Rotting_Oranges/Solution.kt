package leetcode_994_Rotting_Oranges

import java.util.LinkedList

class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = LinkedList<Int>()
        val n = grid.size
        val m = grid[0].size
        var freshCount = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] == 2) {
                    queue.add(i * m + j)
                } else if (grid[i][j] == 1) {
                    ++freshCount
                }
            }
        }

        if (freshCount == 0) {
            return 0
        }

        val directions = arrayOf(
                intArrayOf(1, 0),
                intArrayOf(-1, 0),
                intArrayOf(0, 1),
                intArrayOf(0, -1)
        )
        while (queue.isNotEmpty()) {
            val cell = queue.poll()
            val r = cell / m
            val c = cell % m
            for (d in directions) {
                val rNext = r + d[0]
                val cNext = c + d[1]
                if (rNext in 0 until n && cNext in 0 until m && grid[rNext][cNext] == 1) {
                    --freshCount
                    if (freshCount == 0) {
                        return grid[r][c] - 1
                    }
                    queue.add(rNext * m + cNext)
                    grid[rNext][cNext] = grid[r][c] + 1
                }
            }
        }

        return -1
    }
}