package leetcode_128_Longest_Consecutive_Sequence

import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val mapping = mutableMapOf<Int, Pair<Int, Int>>()
        var result = 0
        for (i in nums.indices) {
            if (mapping.contains(nums[i])) {
                continue
            }

            val prevNote = mapping[nums[i] - 1]
            val nextNote = mapping[nums[i] + 1]
            val min = min(min(prevNote?.first ?: Int.MAX_VALUE, nextNote?.first ?: Int.MAX_VALUE), nums[i])
            val max = max(max(prevNote?.second ?: Int.MIN_VALUE, nextNote?.second ?: Int.MIN_VALUE), nums[i])
            val note = Pair(min, max)
            if (prevNote != null) {
                mapping[nums[i] - 1] = note
            }
            if (nextNote != null) {
                mapping[nums[i] + 1] = note
            }
            mapping[nums[i]] = note
            mapping[min] = note
            mapping[max] = note
//            println("$min $max")
            if (result < max - min + 1) {
                result = max - min + 1
            }
        }

        return result
    }
}

fun main() {
    arrayOf(
            intArrayOf(100,4,200,1,3,2),
            intArrayOf(100,4,200,1,3,2,7,6,5),
            intArrayOf(0,3,7,2,5,8,4,6,0,1),
            intArrayOf(),
    ).forEach {
        Solution().longestConsecutive(it).let(::println)
    }
}

/*
Input: nums = [100,4,200,1,3,2]

100 -> ? 99, 101 -> [100] : 100,100
4 -> ? 3, 5 -> [4]: 4,4
200 -> ? 199, 201 -> [200] : 200,200
1 -> ? 0, 2 -> [1] : 1,1
3 -> ? 2, 4 ->
    current: [4] : 4,4
    -> [3]: 3,4     [4]: 3,4
2 -> ? 1, 3 ->
    current: [1]: 1,1       [3]: 3,4
    -> [1]: 1,4     [2]: 1,4        [3]: 1,4    [4]: 1,4

[more item...]
5 -> ? 4,6 ->
    current: [4]: 1,4
    -> [4]: 1,5     [5]: 1,5        [1]: 1,5

2 -> exist -> continue

 */