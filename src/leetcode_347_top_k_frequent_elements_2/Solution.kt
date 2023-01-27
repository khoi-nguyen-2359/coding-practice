package leetcode_347_top_k_frequent_elements_2

import java.util.*
import kotlin.test.assertContentEquals

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counters = mutableMapOf<Int, Int>()

        // O(n)
        nums.forEach {
            counters[it] = 1 + (counters[it] ?: 0)
        }
        val minHeap = PriorityQueue<Int>(k) { t1, t2 ->
            (counters[t1] ?: 0) - (counters[t2] ?: 0)
        }

        // O(n)
        counters.forEach {
            // O(logk)
            minHeap.add(it.key)
            if (minHeap.size > k) {
                // do this to keep O(logk)
                minHeap.poll()
            }
        }

        // O(nlogk)
        return IntArray(k) { minHeap.poll() }
    }
}

fun main() {
    arrayOf(
        (intArrayOf(1,1,1,2,3,3) to 2) to intArrayOf(3,1),
        (intArrayOf(1,1,2,3) to 1) to intArrayOf(1),
    ).forEach { (inp, exp) ->
        val (nums, k) = inp
        assertContentEquals(exp, Solution().topKFrequent(nums, k))
    }
}