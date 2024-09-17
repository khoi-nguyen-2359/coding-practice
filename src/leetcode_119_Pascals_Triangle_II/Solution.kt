package leetcode_119_Pascals_Triangle_II

import kotlin.test.assertEquals

class Solution {
    private var triangle: MutableList<MutableList<Int>> = mutableListOf()
    fun getRow(rowIndex: Int): List<Int> {
        triangle = MutableList(rowIndex + 1) { MutableList(it + 1) { 0 } }
        return List(rowIndex + 1) { getCell(rowIndex, it) }
    }

    private fun getCell(r: Int, i: Int): Int {
        if (triangle[r][i] != 0) {
            return triangle[r][i]
        }
        if (i == 0 || i == r) {
            triangle[r][i] = 1
            return 1
        }
        val c = getCell(r - 1, i - 1) + getCell(r - 1, i)
        triangle[r][i] = c
        return c
    }
}

fun main() {
    arrayOf(
        0 to listOf(1),
        1 to listOf(1, 1),
        2 to listOf(1, 2, 1),
        3 to listOf(1, 3, 3, 1),
        4 to listOf(1, 4, 6, 4, 1),
    ).forEach { (inp, out) ->
        assertEquals(out, Solution().getRow(inp))
    }
}