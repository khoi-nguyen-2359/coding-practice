package leetcode_74_Search_a_2D_Matrix

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix[0].size
        var l = 0
        var r = matrix.size * n - 1
        while (l <= r) {
            val m = (l + r) / 2
            val col = m % n
            val row = m / n
            if (matrix[row][col] == target) {
                return true
            }
            if (matrix[row][col] < target) {
                l = m + 1
            } else {
                r = m - 1
            }
        }
        return false
    }
}

fun main() {
    Solution().searchMatrix(
            arrayOf(
                    intArrayOf(1,3,5,7),
                    intArrayOf(10,11,16,20),
                    intArrayOf(23,30,34,60)
            ),
            66
    ).let(::println)
}