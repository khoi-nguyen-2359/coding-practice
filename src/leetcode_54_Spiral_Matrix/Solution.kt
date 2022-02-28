package leetcode_54_Spiral_Matrix

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        val n = matrix[0].size
        val m = matrix.size
        val count = matrix[0].size * matrix.size
        var curr = -1
        var step = 1
        var right = n - 1
        var bottom = m - 1
        var left = 0
        var top = 1
        repeat(count) {
            curr += step
            val col = curr % n
            val row = curr / n
            result.add(matrix[row][col])

            when (step) {
                // top right corner
                1 -> if (col == right) {
                    step = n
                    right--
                }
                // bottom right corner
                n -> if (row == bottom) {
                    step = -1
                    bottom--
                }
                // bottom left corner
                -1 -> if (col == left) {
                    step = -n
                    left++
                }
                // top left corner
                -n -> if (row == top) {
                    step = 1
                    top++
                }
            }
        }

        return result
    }
}