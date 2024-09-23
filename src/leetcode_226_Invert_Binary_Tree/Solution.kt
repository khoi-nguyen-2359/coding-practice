package leetcode_226_Invert_Binary_Tree

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
    fun invertTree(root: LcBinTreeNode?): LcBinTreeNode? {
        if (root?.left != null) {
            invertTree(root.left)
        }
        if (root?.right != null) {
            invertTree(root.right)
        }
        val tmp = root?.left
        root?.left = root?.right
        root?.right = tmp
        return root
    }
}

fun main() {
    arrayOf(
            LcBinTreeNode.create(4,2,7,1,3,6,9) to LcBinTreeNode.create(4,7,2,9,6,3,1),
            LcBinTreeNode.create(2,1,3) to LcBinTreeNode.create(2,3,1),
            LcBinTreeNode.create() to LcBinTreeNode.create(),
    ).forEach { (input, output) ->
        assertEquals(output, Solution().invertTree(input))
    }
}