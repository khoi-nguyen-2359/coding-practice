package leetcode_56_merge_intervals.attempt_2

import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()
        var currStart = intervals[0][0]
        var currEnd = intervals[0][1]
        for (i in intervals.indices) {
            if (currEnd >= intervals[i][0]) {
                currStart = min(currStart, intervals[i][0])
                currEnd = max(currEnd, intervals[i][1])
            } else {
                result.add(intArrayOf(currStart, currEnd))
                currStart = intervals[i][0]
                currEnd = intervals[i][1]
            }
        }

        result.add(intArrayOf(currStart, currEnd))

        return result.toTypedArray()
    }
}

fun main() {
    Solution().merge(arrayOf(
            intArrayOf(1,5),
            intArrayOf(0,3)
    )).let {
        it.forEach {
            println("${it[0]}, ${it[1]}")
        }
    }
}

/*
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 */