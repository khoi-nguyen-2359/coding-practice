package leetcode_111_Minimum_Depth_of_Binary_Tree

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
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return minDepth(root, 1)
    }

    private fun minDepth(node: TreeNode?, height: Int): Int = when {
        node?.left != null && node.right != null -> Math.min(
            minDepth(node.left, height + 1),
            minDepth(node.right, height + 1),
        )
        node?.left == null && node?.right != null -> minDepth(node.right, height + 1)
        node?.right == null && node?.left != null -> minDepth(node.left, height + 1)
        else -> height
    }
}