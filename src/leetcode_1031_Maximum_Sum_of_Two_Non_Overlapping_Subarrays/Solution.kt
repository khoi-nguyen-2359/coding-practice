package leetcode_1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays

import java.lang.Integer.max

class SolutionBruteForce {
    private val cacheMap = mutableMapOf<Int, IntArray>()
    fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
        cacheMap.clear()
        cacheMap[firstLen] = IntArray(nums.size)
        cacheMap[secondLen] = IntArray(nums.size)
        buildCache(nums, firstLen)
        buildCache(nums, secondLen)
        val phase1 = phaseMaxSum(nums, firstLen, secondLen)
        val phase2 = phaseMaxSum(nums, secondLen, firstLen)
        return max(phase1, phase2)
    }

    private fun phaseMaxSum(nums: IntArray, firstLen: Int, secondLen: Int): Int {
        var max = 0
        for (i in 0..nums.size - firstLen) {
            val firstSum = cacheMap[firstLen]?.get(i) ?: break
            var leftMax = 0
            for (j in 0..i - secondLen) {
                val sum = cacheMap[secondLen]?.get(j) ?: break
                if (sum > leftMax) {
                    leftMax = sum
                }
            }
            var rightMax = 0
            for (j in i + firstLen..nums.size - secondLen) {
                val sum = cacheMap[secondLen]?.get(j) ?: break
                if (sum > rightMax) {
                    rightMax = sum
                }
            }

            val sum = firstSum + max(leftMax, rightMax)
            if (sum > max) {
                max = sum
            }
        }

        return max
    }

    private fun buildCache(arr: IntArray, len: Int) {
        var sum = 0
        for (i in 0 until len) {
            sum += arr[i]
        }

        cacheMap[len]?.set(0, sum)
        for (i in 1..arr.size - len) {
            sum = sum - arr[i - 1] + arr[i + len - 1]
            cacheMap[len]?.set(i, sum)
        }
    }
}

fun main() {
    SolutionBruteForce().maxSumTwoNoOverlap(
            intArrayOf(8,20,6,2,20,17,6,3,20,8,12),
            5,
            4
    ).let(::println)
}

/*
[8,20,6,2,20,17,6,3,20,8,12]
5
4
 */