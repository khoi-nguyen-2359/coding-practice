package leetcode_114_Flatten_Binary_Tree_to_Linked_List

import TreeNode

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
    private val nodes = mutableListOf<TreeNode>()
    fun flatten(root: TreeNode?) {
        if (root == null) {
            return
        }

        preOrder(root)

        var curr: TreeNode? = root
        root.left = null
        for (i in 1 until nodes.size) {
            nodes[i].left = null
            curr?.right = nodes[i]
            curr = curr?.right
        }
    }

    private fun preOrder(node: TreeNode) {
        nodes.add(node)
        node.left?.let(::preOrder)
        node.right?.let(::preOrder)
    }
}

class SolutionRecursive {
    fun flatten(root: TreeNode?) {
        if (root == null) {
            return
        }
        internalFlatten(root)
    }

    private fun internalFlatten(node: TreeNode): Pair<TreeNode, TreeNode> {
        val flatLeft = node.left?.let(::internalFlatten)
        val flatRight = node.right?.let(::internalFlatten)

        if (flatLeft != null) {
            node.left = null
            val tmp = node.right
            node.right = flatLeft.first
            flatLeft.second.right = tmp
        }

        val tail: TreeNode? = flatRight?.second ?: flatLeft?.second

        return node to (tail ?: node)
    }
}

class SolutionIterative {
    fun flatten(root: TreeNode?) {
        if (root == null) {
            return
        }
        internalFlatten(root)
    }

    private fun internalFlatten(node: TreeNode): Pair<TreeNode, TreeNode> {
        val flatLeft = node.left?.let(::internalFlatten)
        val flatRight = node.right?.let(::internalFlatten)

        if (flatLeft != null) {
            node.left = null
            val tmp = node.right
            node.right = flatLeft.first
            flatLeft.second.right = tmp
        }

        val tail: TreeNode? = flatRight?.second ?: flatLeft?.second

        return node to (tail ?: node)
    }
}