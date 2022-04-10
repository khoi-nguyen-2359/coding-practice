package leetcode_347_Top_K_Frequent_Elements

import java.util.PriorityQueue

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()
        nums.forEach { n ->
            frequencyMap[n] = (frequencyMap[n] ?: 0) + 1
        }
        val priorityQueue = PriorityQueue<Int> { p1, p2 ->
            println("Compare $p1(${frequencyMap[p1]}) and $p2(${frequencyMap[p2]})")
            (frequencyMap[p2] ?: 0) - (frequencyMap[p1] ?: 0)
        }
        frequencyMap.forEach { entry ->
            println("Add ${entry.key}")
            priorityQueue.add(entry.key)
            print("Queue: ")
            priorityQueue.forEach { print("$it ") }
            println()
            println("=====")
        }
        return IntArray(k) { priorityQueue.poll() }
    }
}

fun main() {
    Solution().topKFrequent(intArrayOf(5,3,1,1,1,3,73), 2).forEach(::println)
}