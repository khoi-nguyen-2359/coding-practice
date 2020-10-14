package leetcode_48_rotate_image

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        var count = 0
        var x = 0
        var y = 0
        var prev = matrix[n - x - 1][y]
        var margin = n - 1
        while (count < n * n) {
            var tmp = matrix[x][y]
            matrix[x][y] = prev
            prev = tmp

            tmp = x
            x = y
            y = n - tmp - 1

            ++count
            if (count % 4 == 0) {
                ++y
                if (y >= margin) {
                    y = n - margin
                    ++x
                    --margin
                }
                prev = matrix[n-y-1][x]
            }
        }
    }
}

fun main() {
    val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
    )
    Solution().rotate(matrix)

    matrix.also {
        it.forEach {
            it.forEach {
                print(it)
            }
            println()
        }
    }
}