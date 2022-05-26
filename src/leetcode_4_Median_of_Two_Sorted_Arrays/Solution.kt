package leetcode_4_Median_of_Two_Sorted_Arrays

import java.util.PriorityQueue

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val s = nums1.size + nums2.size
        if (s == 0) {
            return 0.0
        }

        val priorityQueue = PriorityQueue<Int>(s) { t1, t2 -> t1 - t2 }
        nums1.forEach(priorityQueue::add)
        nums2.forEach(priorityQueue::add)

        while (priorityQueue.isNotEmpty()) {
            val k = priorityQueue.poll()
            if (s - priorityQueue.size - 1 == (s - 1) / 2) {
                return if (s % 2 == 0) {
                    (k + priorityQueue.poll()) / 2.0
                } else {
                    k * 1.0
                }
            }
        }

        return 0.0
    }
}

fun main() {
    arrayOf(
            arrayOf(intArrayOf(1,3), intArrayOf(2)),
            arrayOf(intArrayOf(1,2), intArrayOf(3,4)),
            arrayOf(intArrayOf(), intArrayOf()),
    ).forEach {
        Solution().findMedianSortedArrays(it[0], it[1]).let(::println)
    }
}