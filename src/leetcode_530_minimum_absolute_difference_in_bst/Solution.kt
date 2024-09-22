package leetcode_530_minimum_absolute_difference_in_bst

import LcTreeNode as TreeNode

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
    private var min = 0
    private var lastVisited: TreeNode? = null
    fun getMinimumDifference(root: TreeNode?): Int {
        min = Int.MAX_VALUE
        traverse(root)
        return min
    }

    private fun traverse(node: TreeNode?) {
        node ?: return

        traverse(node.left)

        lastVisited?.let {
            min = Math.min(Math.abs(it.`val` - node.`val`), min)
        }
        lastVisited = node

        traverse(node.right)
    }
}