package leetcode_56_merge_intervals.attempt_1

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) {
            return emptyArray()
        }

        intervals.sortBy {
            it[0]
        }

        var i0 = intervals[0][0]
        var i1 = intervals[0][1]
        val result = mutableListOf<IntArray>()
        for (i in 1 until intervals.size) {
            if (i1 >= intervals[i][0]) {
                if (i1 <= intervals[i][1])
                    i1 = intervals[i][1]
            } else {
                result.add(intArrayOf(i0, i1))

                i0 = intervals[i][0]
                i1 = intervals[i][1]
            }
        }

        result.add(intArrayOf(i0, i1))

        return result.toTypedArray()
    }
}

fun main() {
    val intervals = arrayOf(
            intArrayOf(8,10),
            intArrayOf(1,3),
            intArrayOf(2,16),
            intArrayOf(1,20)
    )
    Solution().merge(intervals).also {
        it.forEach { interval ->
            interval.forEach { element ->
                print("$element ")
            }
            println()
        }
    }
}