package leetcode_110_Balanced_Binary_Tree

import LcTreeNode
import kotlin.math.abs
import kotlin.math.max

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

typealias TreeNode = LcTreeNode

class Solution {
    private var isBalanced = true
    fun isBalanced(root: TreeNode?): Boolean {
        height(root)
        return isBalanced
    }

    private fun height(node: TreeNode?): Int {
        if (!isBalanced) {
            return -1 // result is ready, skip.
        }
        if (node == null) {
            return 0
        }
        val lHeight = height(node.left)
        val rHeight = height(node.right)
        val height = 1 + max(lHeight, rHeight)
        isBalanced = isBalanced && abs(lHeight - rHeight) <= 1
        return height
    }
}

fun main() {
    arrayOf(
        TreeNode.create(3,9,20,null, null,15,17) to true,
        TreeNode.create(1,2,2,3,3,null,null,4,4) to false,
        TreeNode.create(1,2,2,3,null,null,3,4,null,null,null,null,null,null,4) to false,
        TreeNode.create(1,2,3,4,5,null,6,7,null,null,null,null,null,null,8) to false,
    ).forEach { (inp, outp) ->
        Solution().isBalanced(inp).let(::println)
    }
}