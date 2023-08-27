package leetcode_56_merge_intervals.attempt_3

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()
        for (i in intervals.indices) {
            val interval = intervals[i]
            if (result.isEmpty() || interval[0] > result.last()[1]) {
                result.add(interval)
            } else {
                result.last()[1] = Math.max(interval[1], result.last()[1])
            }
        }

        return result.toTypedArray()
    }
}