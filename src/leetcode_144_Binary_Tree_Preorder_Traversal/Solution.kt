package leetcode_144_Binary_Tree_Preorder_Traversal

import java.util.*
import LcBinTreeNode as TreeNode

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
    private val result = mutableListOf<Int>()
    fun preorderTraversal(root: TreeNode?): List<Int> {
        root?.`val`?.let {
            result.add(it)
        }
        root?.left?.let {
            preorderTraversal(it)
        }
        root?.right?.let {
            preorderTraversal(it)
        }
        return result
    }
}

class SolutionIterative {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val stack = Stack<TreeNode>()
        root?.let {
            stack.add(it)
        }
        val result = mutableListOf<Int>()
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            result.add(top.`val`)
            if (top.right != null) {
                stack.add(top.right)
            }
            if (top.left != null) {
                stack.add(top.left)
            }
        }
        return result
    }
}