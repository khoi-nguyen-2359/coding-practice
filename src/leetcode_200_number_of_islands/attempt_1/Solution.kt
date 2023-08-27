package leetcode_200_number_of_islands.attempt_1

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var n = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    ++n
                    spread(grid, i, j)
                }
            }
        }

        return n
    }

    private fun spread(grid: Array<CharArray>, i: Int, j: Int) {
        grid[i][j] = 'x'
        if (j + 1 < grid[i].size && grid[i][j + 1] == '1') {
            spread(grid, i, j + 1)
        }

        if (i + 1 < grid.size && grid[i + 1][j] == '1') {
            spread(grid, i + 1, j)
        }

        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            spread(grid, i, j - 1)
        }

        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            spread(grid, i - 1, j)
        }
    }
}

fun main() {
    val grid = arrayOf(
            charArrayOf('1', '1','1'),
            charArrayOf('0', '1','0'),
            charArrayOf('1', '1','1')
    )
    Solution().numIslands(grid).also {
        println(it)
    }
}