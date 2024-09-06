package leetcode_215_kth_largest_element_in_an_array.attempt_1

import java.util.*

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>(k + 1)// { i1, i2 -> i2 - i1 }
        nums.forEach { item ->
            queue.add(item)
            if (queue.size > k)
                queue.poll()
        }

        return queue.peek()
    }
}