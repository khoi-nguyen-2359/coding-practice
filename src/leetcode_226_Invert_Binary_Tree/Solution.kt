package leetcode_226_Invert_Binary_Tree

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
    fun invertTree(root: LcTreeNode?): LcTreeNode? {
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
            LcTreeNode.create(4,2,7,1,3,6,9) to LcTreeNode.create(4,7,2,9,6,3,1),
            LcTreeNode.create(2,1,3) to LcTreeNode.create(2,3,1),
            LcTreeNode.create() to LcTreeNode.create(),
    ).forEach { (input, output) ->
        assertEquals(output, Solution().invertTree(input))
    }
}