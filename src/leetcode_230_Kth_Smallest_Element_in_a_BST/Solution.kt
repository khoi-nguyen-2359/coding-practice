package leetcode_230_Kth_Smallest_Element_in_a_BST

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
    private var ans = -1
    private var k = 0
    fun kthSmallest(root: LcTreeNode?, k: Int): Int {
        root ?: return ans
        this.k = k
        inOrderTraverse(root)
        return ans
    }

    private fun inOrderTraverse(node: LcTreeNode) {
        node.left?.let(::inOrderTraverse)
        // node
        --k
        if (k == 0) {
            ans = node.`val`
        }
        node.right?.let(::inOrderTraverse)
    }
}

fun main() {
    arrayOf(
            LcTreeNode.create(3, 1, 4, null, 2) to 1 to 1,
            LcTreeNode.create(3) to 1 to 3,
            LcTreeNode.create(5, 3, 6, 2, 4, null, null, 1) to 3 to 3,
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().kthSmallest(input.first, input.second))
    }
}