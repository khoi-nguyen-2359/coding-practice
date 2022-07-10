package misc_longest_decr_subarr

import kotlin.test.assertEquals

class Solution {
    fun solve(input: Array<Array<Boolean>>): Int {
        val percentages = input.map {
            val found = searchTheFirstFalse(it)
            found * 1f / it.size
        }
        var max = 0
        var l = 0
        var r = 0
        while (r < percentages.size) {
            if (r == percentages.size - 1 || percentages[r] < percentages[r + 1]) {
                max = Math.max(max, r - l + 1)
                l = r + 1
                r = l
            } else {
                ++r
            }
        }

        return max
    }

    private fun searchTheFirstFalse(array: Array<Boolean>): Int {
        var l = 0
        var r = array.size - 1
        while (l <= r) {
            val m = (l + r) / 2
            if (array[m]) {
                l = m + 1
            } else if (m <= 0 || array[m - 1]) {
                return m
            } else {
                r = m - 1
            }
        }
        return array.size
    }
}

fun main() {
    arrayOf(
            arrayOf(
                    arrayOf(true, true, true, false, false),
                    arrayOf(true, true, true, true, false),
                    arrayOf(true, true, true, true, true, true, false, false, false),
                    arrayOf(true, false, false, false, false, false),
                    arrayOf(true, true, true, true, true, true, true, true, true, true, true, true, false),
                    arrayOf(true, false),
                    arrayOf(true, true, true, true, false, false),
            ) to 3,
            arrayOf(
                    arrayOf(true, true, true, false, false),
                    arrayOf(true, true, true, true, false),
                    arrayOf(true, true, true, true, true, true, false, false, false),
                    arrayOf(true, false, false, false, false, false),
            ) to 3,
            arrayOf(
                    arrayOf(true, true, true, true, true, true, true, true, true, true, true, true, false),
                    arrayOf(true, false),
                    arrayOf(true, true, true, true, false, false),
            ) to 2,
            arrayOf(
                    arrayOf(true, true, true, true, true, true, true, true, true, true, true, true, true),
                    arrayOf(true, true),
                    arrayOf(true, true, true, true, false, false),
            ) to 3,
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().solve(input))
    }
}