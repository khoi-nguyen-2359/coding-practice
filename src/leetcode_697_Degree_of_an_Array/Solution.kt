package leetcode_697_Degree_of_an_Array

class Solution {
    fun findShortestSubArray(nums: IntArray): Int {
        val frequencyMap = mutableMapOf<Int, Int>()
        val firstIndexMap = mutableMapOf<Int, Int>()
        var degree = 0
        var minLength = Int.MAX_VALUE
        for (i in nums.indices) {
            if (!firstIndexMap.contains(nums[i])) {
                firstIndexMap[nums[i]] = i
            }
            val frequency = (frequencyMap[nums[i]] ?: 0) + 1
            frequencyMap[nums[i]] = frequency
            if (frequency >= degree) {
                val length = i - (firstIndexMap[nums[i]] ?: 0) + 1
                if (length < minLength || frequency > degree) {
                    minLength = length
                }
                degree = frequency
            }
        }

        return minLength
    }
}

// Input: nums = [1,2,2,3,1,4,2]