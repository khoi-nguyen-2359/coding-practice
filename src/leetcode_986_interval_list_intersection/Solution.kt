package leetcode_986_interval_list_intersection

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        var i = 0
        var j = 0
        val result = mutableListOf<IntArray>()
        while (i < firstList.size && j < secondList.size) {
            val f = firstList[i]
            val s = secondList[j]
            val left = max(f[0], s[0])
            val right = min(f[1], s[1])
            if (left <= right) {
                result.add(intArrayOf(left, right))
            }

            if (f[1] < s[1]) {
                ++i
            } else {
                ++j
            }
        }

        return result.toTypedArray()
    }
}