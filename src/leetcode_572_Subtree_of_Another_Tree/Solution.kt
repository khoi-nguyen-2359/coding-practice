package leetcode_572_Subtree_of_Another_Tree

import TreeNode
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
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (compareTree(root, subRoot)) {
            return true
        }
        if (root == null) {
            return false
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    private fun compareTree(t1: TreeNode?, t2: TreeNode?): Boolean {
        if (t1 == null && t2 == null) {
            return true
        }
        if (t1?.`val` != t2?.`val`) {
            return false
        }
        val isLeftEqual = compareTree(t1?.left, t2?.left)
        val isRightEqual = compareTree(t1?.right, t2?.right)
        return isLeftEqual && isRightEqual
    }
}

fun main() {
    arrayOf(
            TreeNode.create(3,4,5,1,2) to TreeNode.create(4,1,2) to true,
            TreeNode.create(3,4,5,1,2,null,null,null,null,0) to TreeNode.create(4,1,2) to false,
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().isSubtree(input.first, input.second))
    }
}