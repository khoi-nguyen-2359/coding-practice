package leetcode_543_diameter_of_binary_tree.attempt_2

import LcBinTreeNode
import kotlin.test.assertEquals

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    private var diameter = 0
    fun diameterOfBinaryTree(root: LcBinTreeNode?): Int {
        maxDepth(root, 0)
        return diameter
    }

    private fun maxDepth(node: LcBinTreeNode?, depth: Int): Int {
        val leftMax = node?.left?.let { maxDepth(it, depth + 1) } ?: depth
        val rightMax = node?.right?.let { maxDepth(it, depth + 1) } ?: depth
        diameter = Math.max(leftMax + rightMax - 2 * depth, diameter)
        return Math.max(leftMax, rightMax)
    }
}

fun main() {
    arrayOf(
            LcBinTreeNode.create(1,2,3,4,5) to 3,
            LcBinTreeNode.create(1,2) to 1,
    ).forEach { (root, exp) ->
        assertEquals(exp, Solution().diameterOfBinaryTree(root))
    }
}