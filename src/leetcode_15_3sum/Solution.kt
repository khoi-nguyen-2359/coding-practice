package leetcode_15_3sum

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val valueToPosMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, n ->
            valueToPosMap[n] = index
        }
        val result = HashSet<List<Int>>()
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val sum2 = nums[i] + nums[j]
                val sum2Pos = valueToPosMap[-sum2]
                if (sum2Pos == null || sum2Pos <= j) {
                    continue
                }
                result.add(listOf(nums[i], nums[j], -sum2).sorted())
            }
        }

        return result.toList()
    }
}