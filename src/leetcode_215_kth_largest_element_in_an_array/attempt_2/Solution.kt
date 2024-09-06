package leetcode_215_kth_largest_element_in_an_array.attempt_2

import java.util.PriorityQueue

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pQueue = PriorityQueue<Int>(k + 1)
        // O(n)
        nums.forEach { n ->
            pQueue.add(n) // O(logk)
            if (pQueue.size > k) {
                pQueue.poll() // O(logk)
            }
        }
        return pQueue.peek() // O(1)
    } // => O(n * logk)
}