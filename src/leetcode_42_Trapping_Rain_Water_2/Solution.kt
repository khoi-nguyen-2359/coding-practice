package leetcode_42_Trapping_Rain_Water_2

class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var leftMax = 0
        var rightMax = 0
        var result = 0
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]
                }
                result += leftMax - height[left]
                ++left
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]
                }
                result += rightMax - height[right]
                --right
            }
        }

        return result
    }
}

fun main() {
    arrayOf(
            intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1),
            intArrayOf(4,2,0,3,2,5),
    ).forEach {
        Solution().trap(it).let(::println)
    }
}