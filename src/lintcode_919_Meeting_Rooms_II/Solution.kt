package lintcode_919_Meeting_Rooms_II

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
     * @return: the minimum number of conference rooms required
     */
    fun minMeetingRooms(intervals: List<Interval?>): Int {
        val starts = intervals.mapNotNull { it?.start }.sorted()
        val ends = intervals.mapNotNull { it?.end }.sorted()

        var i = 0
        var j = 0
        var curr = 0
        var result = 0
        while (i < intervals.size) {
            if (starts[i] < ends[j]) {
                ++i
                ++curr
            } else {
                ++j
                --curr
            }
            if (result < curr) {
                result = curr
            }
        }

        return result
    }
}

fun main() {
    arrayOf(
            listOf(Interval(0,30), Interval(5,10), Interval(15,20)),
            listOf(Interval(5,10), Interval(15,20), Interval(0,30)),
            listOf(Interval(5,10), Interval(15,20)),
            listOf(Interval(10,11), Interval(5,15), Interval(10,20),),
    ).forEach {
        Solution().minMeetingRooms(it).let(::println)
    }
}