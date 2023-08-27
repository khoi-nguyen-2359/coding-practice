package leetcode_124_Binary_Tree_Maximum_Path_Sum.attempt_1

import TreeNode

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
    private var result = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        result = Int.MIN_VALUE
        max_gain(root)
        return result
    }

    private fun max_gain(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val leftMaxGain = max_gain(node.left)
        val rightMaxGain = max_gain(node.right)
        val path = leftMaxGain + rightMaxGain + node.`val`
        if (path > result) {
            result = path
        }

        return Math.max(Math.max(leftMaxGain, rightMaxGain) + node.`val`, 0)
    }
}

fun main() {
    arrayOf(
            TreeNode.create(1,2,3),
            TreeNode.create(-10,9,20,null,null,15,7),
            TreeNode.create(2,-1),
    ).forEach {
        Solution().maxPathSum(it).let(::println)
    }
}