package leetcode_102_Binary_Tree_Level_Order_Traversal

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
    fun levelOrder(root: LcTreeNode?): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        root ?: return ans
        val queue = ArrayDeque<Pair<LcTreeNode, Int>>()
        queue.addLast(root to 0)
        var currLevel = 0
        var currAns = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val (node, level) = queue.removeFirst()
            if (level > currLevel) {
                currLevel = level
                ans.add(currAns)
                currAns = mutableListOf()
            }
            currAns.add(node.`val`)

            node.left?.let {
                queue.addLast(it to level + 1)
            }
            node.right?.let {
                queue.addLast(it to level + 1)
            }
        }

        if (currAns.isNotEmpty()) {
            ans.add(currAns.toList())
        }

        return ans
    }
}

fun main() {
    arrayOf(
            LcTreeNode.create(3, 9, 20, null, null, 15, 7) to listOf(listOf(3), listOf(9, 20), listOf(15, 7)),
            LcTreeNode.create(2, 1) to listOf(listOf(2), listOf(1)),
            LcTreeNode.create(2, 1, null, null, 3) to listOf(listOf(2), listOf(1), listOf(3)),
            LcTreeNode.create(1) to listOf(listOf(1)),
            LcTreeNode.create() to listOf(),
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().levelOrder(input))
    }
}