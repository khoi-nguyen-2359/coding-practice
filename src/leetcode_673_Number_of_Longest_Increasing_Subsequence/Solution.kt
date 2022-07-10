package leetcode_673_Number_of_Longest_Increasing_Subsequence

import kotlin.test.assertEquals

class Solution {
    private var ansMaxLen = 0
    private var ansCount = 0
    private val memo = mutableMapOf<Int, MemoEntry>()
    fun findNumberOfLIS(nums: IntArray): Int {
        for (i in nums.indices) {
            val memoEntry = findMaxSubsLen(nums, i)
            if (memoEntry.maxLen > ansMaxLen) {
                ansMaxLen = memoEntry.maxLen
                ansCount = memoEntry.count
            } else if (memoEntry.maxLen == ansMaxLen) {
                ansCount += memoEntry.count
            }
        }
        return ansCount
    }

    private fun findMaxSubsLen(nums: IntArray, start: Int): MemoEntry {
        memo[start]?.let {
            return it
        }
        var count = 1
        var maxLen = 1
        for (i in start + 1 until nums.size) {
            if (nums[i] > nums[start]) {
                val (iMaxLen, iCount) = findMaxSubsLen(nums, i)
                val len = iMaxLen + 1
                if (len > maxLen) {
                    count = iCount
                    maxLen = len
                } else if (len == maxLen) {
                    count += iCount
                }
            }
        }

        val memoEntry = MemoEntry(maxLen, count)
        memo[start] = memoEntry

        return memoEntry
    }

    data class MemoEntry(val maxLen: Int, val count: Int)
}

fun main() {
    arrayOf(
            intArrayOf(1, 3, 5, 4, 7) to 2,
            intArrayOf(1, 2, 4, 3, 5, 4, 7, 2) to 3,
            intArrayOf(1, 1, 1, 2, 2, 2, 3, 3, 3) to 27,
            intArrayOf(2, 2, 2, 2, 2) to 5,
            intArrayOf(2, 1, 6, 2, 2) to 4,
            intArrayOf(2) to 1,
            intArrayOf(1,2,3,4,5) to 1,
    ).forEach { (inp, exp) ->
        assertEquals(exp, Solution().findNumberOfLIS(inp))
    }
}