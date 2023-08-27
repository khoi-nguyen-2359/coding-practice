package leecode_110_Balanced_Binary_Tree

import LcTreeNode
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
    fun isBalanced(root: LcTreeNode?): Boolean {
        return height(root) != -1
    }

    private fun height(node: LcTreeNode?): Int {
        if (node == null) {
            return 0
        }
        val leftHeight = height(node.left)
        val rightHeight = height(node.right)
        return if (leftHeight != -1 && rightHeight != -1 && Math.abs(leftHeight - rightHeight) <= 1) {
            Math.max(leftHeight, rightHeight) + 1
        } else {
            -1
        }
    }
}

fun main() {
    arrayOf(
            LcTreeNode.create(3,9,20,null,null,15,7) to true,
            LcTreeNode.create(1,2,2,3,3,null,null,4,4) to false,
            LcTreeNode.create() to true,
            LcTreeNode.create(1,2,3,4,5,null,6,7,null,null,null,null,null,8) to false,
            LcTreeNode.create(1,2,2,3,null,null,3,4,null,null,null,null,null,4) to false,
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().isBalanced(input))
    }
}