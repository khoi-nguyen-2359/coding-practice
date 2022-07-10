package leetcode_695_Max_Area_of_Island

class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    max = Math.max(measureArea(grid, i, j), max)
                }
            }
        }

        return max
    }

    private fun measureArea(grid: Array<IntArray>, r: Int, c: Int): Int {
        grid[r][c] = 0
        var area = 1 // this cell
        val directions = arrayOf(
                arrayOf(-1, 0), // above
                arrayOf(1, 0), // below
                arrayOf(0, -1), // left
                arrayOf(0, 1), // right
        )
        for (d in directions) {
            val nextR = r + d[0]
            val nextC = c + d[1]
            if (nextR >= 0 && nextR < grid.size && nextC >= 0 && nextC < grid[nextR].size && grid[nextR][nextC] == 1) {
                area += measureArea(grid, nextR, nextC)
            }
        }

        return area
    }
}