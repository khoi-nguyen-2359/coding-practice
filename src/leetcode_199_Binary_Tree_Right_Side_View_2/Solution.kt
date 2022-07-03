package leetcode_199_Binary_Tree_Right_Side_View_2

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
    fun rightSideView(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        root ?: return ans
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        queue.addLast(root to 0)
        var currLevel = 0
        var lastNode: TreeNode = root
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
            TreeNode.create(3, 9, 20, null, null, 15, 7) to listOf(3, 20, 7),
            TreeNode.create(1, 2, 3, null, 5, null, 4) to listOf(1, 3, 4),
            TreeNode.create(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5) to listOf(6, 8, 9, 5),
            TreeNode.create(2, 1) to listOf(2, 1),
            TreeNode.create(2, 1, null, null, 3) to listOf(2, 1, 3),
            TreeNode.create(1) to listOf(1),
            TreeNode.create() to listOf(),
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().rightSideView(input))
    }
}