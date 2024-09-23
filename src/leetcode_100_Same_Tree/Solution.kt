package leetcode_100_Same_Tree

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
    fun isSameTree(p: LcBinTreeNode?, q: LcBinTreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        if (p?.`val` != q?.`val`) {
            return false
        }
        val isLeftEqual = isSameTree(p?.left, q?.left)
        val isRightEqual = isSameTree(p?.right, q?.right)
        return isLeftEqual && isRightEqual
    }
}

fun main() {
    arrayOf(
            LcBinTreeNode.create(1, 2, 3) to LcBinTreeNode.create(1, 2, 3) to true,
            LcBinTreeNode.create(1, 2) to LcBinTreeNode.create(1, null, 2) to false,
            LcBinTreeNode.create(1, 2, 1) to LcBinTreeNode.create(1, 1, 2) to false,
    ).forEachIndexed { index, (input, exp) ->
        val (p, q) = input
        assertEquals(exp, Solution().isSameTree(p, q), "$index")
    }
}