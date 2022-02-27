package leetcode_922_Sort_Array_By_Parity_II

class Solution {
    fun sortArrayByParityII(nums: IntArray): IntArray {
        val stack = mutableListOf<Int>()
        for (i in nums.indices) {
            if (i % 2 != nums[i] % 2) {
                if (stack.isNotEmpty() && nums[i] % 2 != nums[stack.last()] % 2) {
                    val last = stack.last()
                    stack.removeAt(stack.size - 1)
                    val tmp = nums[i]
                    nums[i] = nums[last]
                    nums[last] = tmp
                } else {
                    stack.add(i)
                }
            }
        }
        return nums
    }
}

// Input: nums = [4,[2],6,[10],[17],3,[15],17]