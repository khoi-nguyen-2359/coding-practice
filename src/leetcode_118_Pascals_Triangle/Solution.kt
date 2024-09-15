package leetcode_118_Pascals_Triangle

import kotlin.test.assertEquals

// complexity: O(n^2)
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val triangle = MutableList(numRows) { MutableList(it + 1) { 1 } }
        for (r in 1 until numRows) {
            for (i in 1 until r) {
                triangle[r][i] = triangle[r - 1][i - 1] + triangle[r - 1][i]
            }
        }

        return triangle
    }
}

fun main() {
    arrayOf(
        1 to listOf(listOf(1)),
        2 to listOf(listOf(1), listOf(1, 1)),
        3 to listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1)),
        4 to listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1), listOf(1, 3, 3, 1)),
        5 to listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1), listOf(1, 3, 3, 1), listOf(1, 4, 6, 4, 1)),
    ).forEach { (inp, out) ->
        assertEquals(out, Solution().generate(inp))
    }
}