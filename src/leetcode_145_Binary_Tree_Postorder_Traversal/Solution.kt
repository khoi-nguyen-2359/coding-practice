package leetcode_145_Binary_Tree_Postorder_Traversal

import java.util.*
import LcTreeNode as TreeNode

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
class SolutionRecursive {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val order = mutableListOf<Int>()
        postOrderVisit(root, order)
        return order
    }

    private fun postOrderVisit(node: TreeNode?, order: MutableList<Int>) {
        if (node == null) {
            return
        }
        postOrderVisit(node.left, order)
        postOrderVisit(node.right, order)
        order.add(node.`val`)
    }
}

class SolutionIterative {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val stack = Stack<TreeNode>()
        if (root != null) {
            stack.push(root)
        }
        val order = mutableListOf<Int>()
        var lastVisited: TreeNode? = null
        while (stack.isNotEmpty()) {
            val top = stack.peek()
            when {
                (top.left == null && top.right == null) ||
                (top.right == null && lastVisited == top.left) ||
                (top.right != null && lastVisited == top.right) -> {
                    stack.pop()
                    order.add(top.`val`)
                    lastVisited = top
                }
                else -> {
                    if (top.right != null) {
                        stack.add(top.right)
                    }
                    if (top.left != null) {
                        stack.add(top.left)
                    }
                }
            }
        }

        return order
    }
}