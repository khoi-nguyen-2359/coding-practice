package lintcode_920_Meeting_Rooms

import Interval

/**
 * Definition of Interval:
 * class Interval {
 *     var start: Int = 0
 *     var end: Int = 0
 *     constructor(start: Int, end: Int) {
 *         this.start = start
 *         this.end = end
 *     }
 * }
 */

class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    fun canAttendMeetings(intervals: List<Interval?>): Boolean {
        val sorted = intervals.sortedBy { it?.start }
        for (i in 0..sorted.size - 2) {
            val curr = sorted[i]
            val next = sorted[i + 1]
            if (curr == null || next == null) {
                continue
            }
            if (curr.end > next.start) {
                return false
            }
        }

        return true
    }


}

fun main() {
    arrayOf(
            listOf(Interval(0, 30), Interval(5, 10), Interval(15, 20)),
            listOf(Interval(5, 8), Interval(9, 15)),
            listOf(Interval(9, 15), Interval(5, 9)),
            listOf(Interval(5, 8), Interval(8, 15)),
            listOf(Interval(5, 8), Interval(6, 15)),
            listOf(Interval(5, 8)),
    ).forEach {
        Solution().canAttendMeetings(it).let(::println)
    }
}