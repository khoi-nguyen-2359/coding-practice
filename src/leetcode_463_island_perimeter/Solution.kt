package leetcode_463_island_perimeter

class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var perimeter = 0
        grid.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, cell ->
                if (cell == 1) {
                    perimeter += isWater(grid, rowIndex, colIndex - 1) +
                            isWater(grid, rowIndex - 1, colIndex) +
                            isWater(grid, rowIndex, colIndex + 1) +
                            isWater(grid, rowIndex + 1, colIndex)
                }
            }
        }

        return perimeter
    }

    private fun isWater(grid: Array<IntArray>, r: Int, c: Int): Int =
            if ((r >= 0 && r < grid.size && c >= 0 && c < grid[r].size && grid[r][c] == 0) ||
                    r < 0 || r >= grid.size || c < 0 || c >= grid[r].size) {
                1
            } else {
                0
            }
}

fun main() {
    val grid1 = arrayOf(
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 1, 0),
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 0, 0)
    )
    val grid2 = arrayOf(
            intArrayOf(0)
    )
    val perimeter = Solution().islandPerimeter(grid2)
    println(perimeter)
}
