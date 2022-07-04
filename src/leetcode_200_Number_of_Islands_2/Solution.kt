package leetcode_200_Number_of_Islands_2

import java.util.LinkedList
import kotlin.test.assertEquals

class SolutionDFS {
    fun numIslands(grid: Array<CharArray>): Int {
        var c = '2'
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    fill(grid, i, j, c)
                    ++c
                }
            }
        }

        return c - '2'
    }

    private fun fill(grid: Array<CharArray>, i: Int, j: Int, c: Char) {
        grid[i][j] = c
        if (j + 1 < grid[i].size && grid[i][j + 1] == '1') {
            fill(grid, i, j + 1, c)
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            fill(grid, i, j - 1, c)
        }
        if (i + 1 < grid.size && grid[i + 1][j] == '1') {
            fill(grid, i + 1, j, c)
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            fill(grid, i - 1, j, c)
        }
    }
}

class SolutionBFS {
    private var m = 0
    fun numIslands(grid: Array<CharArray>): Int {
        m = grid[0].size
        var count = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    fill(grid, i, j)
                    ++count
                }
            }
        }

        return count
    }

    private fun cellOf(i: Int, j: Int) = i * m + j

    private fun fill(grid: Array<CharArray>, r: Int, c: Int) {
        val queue = LinkedList<Int>()
        queue.addLast(r * m + c)
        while (queue.isNotEmpty()) {
            val cell = queue.removeFirst()
            val i = cell / m
            val j = cell % m
            grid[i][j] = '0'
            if (j + 1 < grid[i].size && grid[i][j + 1] == '1') {
                queue.add(cellOf(i, j + 1))
                grid[i][j + 1] = '0'
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                queue.add(cellOf(i, j - 1))
                grid[i][j - 1] = '0'
            }
            if (i + 1 < grid.size && grid[i + 1][j] == '1') {
                queue.add(cellOf(i + 1, j))
                grid[i+1][j] = '0'
            }
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                queue.add(cellOf(i - 1, j))
                grid[i-1][j] = '0'
            }
        }
    }
}

fun main() {
    arrayOf(
            arrayOf(
                    charArrayOf('1','1','1','1','0'),
                    charArrayOf('1','1','0','1','0'),
                    charArrayOf('1','1','0','0','0'),
                    charArrayOf('0','0','0','0','0'),
            ) to 1,
            arrayOf(
                    charArrayOf('1','1','0','0','0'),
                    charArrayOf('1','1','0','0','0'),
                    charArrayOf('0','0','1','0','0'),
                    charArrayOf('0','0','0','1','1'),
            ) to 3,
            arrayOf(
                    charArrayOf('1','1','1','1','1'),
                    charArrayOf('1','1','0','0','1'),
                    charArrayOf('0','0','1','0','1'),
                    charArrayOf('0','0','0','1','1'),
            ) to 2,
    ).forEach { (input, exp) ->
        assertEquals(exp, SolutionBFS().numIslands(input))
    }
}