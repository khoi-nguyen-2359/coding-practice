package leetcode_2164_Sort_Even_and_Odd_Indices_Independently

import java.util.*

class Solution {
    fun sortEvenOdd(nums: IntArray): IntArray {
        val oddTreeSet = PriorityQueue<Int> { p0, p1 -> p1 - p0 }
        val evenTreeSet = PriorityQueue<Int> { p0, p1 -> p0 - p1 }
        for (i in nums.indices) {
            if (i % 2 == 0) {
                evenTreeSet.add(nums[i])
            } else {
                oddTreeSet.add(nums[i])
            }
        }
        return IntArray(nums.size) { index ->
            if (index % 2 == 0) {
                evenTreeSet.poll()
            } else {
                oddTreeSet.poll()
            }
        }
    }
}