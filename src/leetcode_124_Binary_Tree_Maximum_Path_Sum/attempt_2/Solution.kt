package leetcode_124_Binary_Tree_Maximum_Path_Sum.attempt_2;

import LcTreeNode
import kotlin.test.assertEquals

class Solution {
    private var maxPathSum = Int.MIN_VALUE
    fun maxPathSum(root: LcTreeNode?): Int {
        maxGain(root)
        return maxPathSum
    }

    private fun maxGain(node: LcTreeNode?): Int {
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
            LcTreeNode.create(1, 2, 3) to 6,
            LcTreeNode.create(-10, 9, 20, null, null, 15, 7) to 42,
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().maxPathSum(input))
    }
}