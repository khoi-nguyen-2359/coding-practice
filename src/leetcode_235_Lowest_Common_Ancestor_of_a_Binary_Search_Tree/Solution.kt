package leetcode_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree

import TreeNode
import leetcode_236_Lowest_Common_Ancestor_of_a_Binary_Tree.Solution
import kotlin.test.assertEquals

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val pVal = p?.`val` ?: return null
        val qVal = q?.`val` ?: return null
        var curr = root
        while (true) {
            val parentVal = curr?.`val` ?: return null
            if (pVal < parentVal && qVal < parentVal) {
                curr = curr.left
            } else if (pVal > parentVal && qVal > parentVal) {
                curr = curr.right
            } else {
                return curr
            }
        }

        return null
    }
}

fun main() {
    arrayOf(
            Triple(TreeNode.create(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5), 2, 8) to 6,
            Triple(TreeNode.create(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5), 2, 4) to 2,
            Triple(TreeNode.create(2, 1), 2, 1) to 2,
            Triple(TreeNode.create(2, 1), 1, 2) to 2,
            Triple(TreeNode.create(2, 1), 1, 1) to 1,
            Triple(TreeNode.create(1), 1, 1) to 1,
    ).forEach { (input, exp) ->
        val (root, p, q) = input
        assertEquals(exp, Solution().lowestCommonAncestor(root, TreeNode(p), TreeNode(q))?.`val`)
    }
}