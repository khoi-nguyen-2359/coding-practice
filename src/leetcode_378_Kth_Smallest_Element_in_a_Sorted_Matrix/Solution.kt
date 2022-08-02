package leetcode_378_Kth_Smallest_Element_in_a_Sorted_Matrix

import java.util.PriorityQueue

class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val maxQueue = PriorityQueue<Int> { i1, i2 -> i2 - i1 }
        for (i in matrix.indices) {
            for (num in matrix[i]) {
                if (maxQueue.isEmpty() || maxQueue.size < k) {
                    maxQueue.add(num)
                } else {
                    if (num <= maxQueue.peek()) {
                        maxQueue.poll()
                        maxQueue.add(num)
                    }
                }
            }
        }

        return maxQueue.peek()
    }
}
