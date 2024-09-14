package leetcode_112_path_sum

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
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }

        return dfs(root, targetSum, 0)
    }

    private fun dfs(node: TreeNode, targetSum: Int, currSum: Int): Boolean {
        if (node.left == null && node.right == null && currSum + node.`val` == targetSum) {
            return true
        }

        val hasLeftPathSum = node.left?.let { left ->
            dfs(left, targetSum, node.`val` + currSum)
        }

        if (hasLeftPathSum == true) {
            return true
        }

        return node.right?.let { right ->
            dfs(right, targetSum, node.`val` + currSum)
        }
            ?: false
    }
}

class SolutionNoSupportFunc {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }
        if (root.left == null && root.right == null && targetSum - root.`val` == 0) {
            return true
        }

        return hasPathSum(root.left, targetSum - root.`val`)
                || hasPathSum(root.right, targetSum - root.`val`)
    }
}