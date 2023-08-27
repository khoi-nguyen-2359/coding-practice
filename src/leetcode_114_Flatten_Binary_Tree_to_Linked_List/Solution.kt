package leetcode_114_Flatten_Binary_Tree_to_Linked_List

import LcTreeNode

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
    private val nodes = mutableListOf<LcTreeNode>()
    fun flatten(root: LcTreeNode?) {
        if (root == null) {
            return
        }

        preOrder(root)

        var curr: LcTreeNode? = root
        root.left = null
        for (i in 1 until nodes.size) {
            nodes[i].left = null
            curr?.right = nodes[i]
            curr = curr?.right
        }
    }

    private fun preOrder(node: LcTreeNode) {
        nodes.add(node)
        node.left?.let(::preOrder)
        node.right?.let(::preOrder)
    }
}

class SolutionRecursive {
    fun flatten(root: LcTreeNode?) {
        if (root == null) {
            return
        }
        internalFlatten(root)
    }

    private fun internalFlatten(node: LcTreeNode): Pair<LcTreeNode, LcTreeNode> {
        val flatLeft = node.left?.let(::internalFlatten)
        val flatRight = node.right?.let(::internalFlatten)

        if (flatLeft != null) {
            node.left = null
            val tmp = node.right
            node.right = flatLeft.first
            flatLeft.second.right = tmp
        }

        val tail: LcTreeNode? = flatRight?.second ?: flatLeft?.second

        return node to (tail ?: node)
    }
}

class SolutionIterative {
    fun flatten(root: LcTreeNode?) {
        if (root == null) {
            return
        }

        var curr = root
        while (curr != null) {
            // If the node has a left child
                // find the rightmost node of left branch
                // place the right branch after that rightmost
                // place the left branch to right

            // move on to the right side of the tree
        }
    }
}