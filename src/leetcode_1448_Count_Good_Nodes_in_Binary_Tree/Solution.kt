package leetcode_1448_Count_Good_Nodes_in_Binary_Tree

import TreeNode
import java.util.Stack
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
    fun goodNodes(root: TreeNode?): Int {
        root ?: return 0
        var result = 0
        val stack = Stack<Pair<TreeNode, Int>>()
        stack.push(root to root.`val`)
        while (stack.isNotEmpty()) {
            val (node, currMax) = stack.pop()
            if (node.`val` >= currMax) {
                ++result
            }
            node.left?.let { left ->
                stack.push(left to Math.max(currMax, left.`val`))
            }
            node.right?.let { right ->
                stack.push(right to Math.max(currMax, right.`val`))
            }
        }
        return result
    }
}

fun main() {
    arrayOf(
            TreeNode.create(3, 1, 4, 3, null, 1, 5) to 4,
            TreeNode.create(3,3,null,4,2) to 3,
            TreeNode.create(1) to 1,
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().goodNodes(input))
    }
}
