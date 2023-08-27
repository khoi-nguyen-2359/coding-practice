package leetcode_199_binary_tree_right_side_view.attempt_2

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
    fun rightSideView(root: LcTreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        root ?: return ans
        val queue = ArrayDeque<Pair<LcTreeNode, Int>>()
        queue.addLast(root to 0)
        var currLevel = 0
        var lastNode: LcTreeNode = root
        while (queue.isNotEmpty()) {
            val (node, level) = queue.removeFirst()
            if (level > currLevel) {
                currLevel = level
                ans.add(lastNode.`val`)
            }
            lastNode = node

            node.left?.let {
                queue.addLast(it to level + 1)
            }
            node.right?.let {
                queue.addLast(it to level + 1)
            }
        }

        lastNode.`val`.let(ans::add)

        return ans
    }
}

fun main() {
    arrayOf(
            LcTreeNode.create(3, 9, 20, null, null, 15, 7) to listOf(3, 20, 7),
            LcTreeNode.create(1, 2, 3, null, 5, null, 4) to listOf(1, 3, 4),
            LcTreeNode.create(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5) to listOf(6, 8, 9, 5),
            LcTreeNode.create(2, 1) to listOf(2, 1),
            LcTreeNode.create(2, 1, null, null, 3) to listOf(2, 1, 3),
            LcTreeNode.create(1) to listOf(1),
            LcTreeNode.create() to listOf(),
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().rightSideView(input))
    }
}