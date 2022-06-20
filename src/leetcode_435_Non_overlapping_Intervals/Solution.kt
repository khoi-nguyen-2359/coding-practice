package leetcode_435_Non_overlapping_Intervals

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) {
            return 0
        }
        val sorted = intervals.sortedBy { it[0] }
        var ans = 0
        var prevEnd = sorted[0][1]
        for (i in 1 until sorted.size) {
            if (sorted[i][0] < prevEnd) {
                ++ans
                prevEnd = Math.min(sorted[i][1], prevEnd)
            } else {
                prevEnd = sorted[i][1]
            }
        }
        return ans
    }
}

/*
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3]

[1  2]
[1      3]
    [2  3]
    [2      4]
        [3  4]
 */