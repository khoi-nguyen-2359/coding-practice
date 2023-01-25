package leetcode_124_Binary_Tree_Maximum_Path_Sum_2;

import TreeNode
import kotlin.test.assertEquals

class Solution {
    private var maxPathSum = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        maxGain(root)
        return maxPathSum
    }

    private fun maxGain(node: TreeNode?): Int {
        val nodeVal = node?.`val` ?: 0
        val leftMaxGain = node?.left?.let(::maxGain) ?: 0
        val rightMaxGain = node?.right?.let(::maxGain) ?: 0
        val maxSum = nodeVal + leftMaxGain + rightMaxGain
        val maxGain = Math.max(Math.max(leftMaxGain, rightMaxGain) + nodeVal, 0)
        if (maxPathSum < maxSum) {
            maxPathSum = maxSum
        }
        return maxGain
    }
}

fun main() {
    arrayOf(
            TreeNode.create(1, 2, 3) to 6,
            TreeNode.create(-10, 9, 20, null, null, 15, 7) to 42,
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().maxPathSum(input))
    }
}