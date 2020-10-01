package leetcode_199_binary_tree_right_side_view

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private var traversedHeight = -1
    private val rightSideView = mutableListOf<Int>()

    class NodeWrap(
            val node: TreeNode,
            val height: Int
    )

    private fun traverse(node: TreeNode?, height: Int) {
        if (node != null && height > traversedHeight) {
            rightSideView.add(node.`val`)
            traversedHeight = height
        }

        if (node?.right != null) {
            traverse(node.right, height + 1)
        }

        if (node?.left != null) {
            traverse(node.left, height + 1)
        }
    }

    private fun traverseIteractive(root: TreeNode?): List<Int> {
        val traverseStack = Stack<NodeWrap>()
        if (root != null) {
            traverseStack.push(NodeWrap(root, 1))
        }
        var traversedHeight = 0
        val result = mutableListOf<Int>()
        while (traverseStack.isNotEmpty()) {
            val peek = traverseStack.pop()
            if (peek.height > traversedHeight) {
                result.add(peek.node.`val`)
                traversedHeight = peek.height
            }
            peek.node.left?.let {
                traverseStack.push(NodeWrap(it, peek.height + 1))
            }
            peek.node.right?.let {
                traverseStack.push(NodeWrap(it, peek.height + 1))
            }
        }

        return result
    }

    fun rightSideView(root: TreeNode?): List<Int> {
//        traverse(root, 0)
//        return rightSideView

        return traverseIteractive(root)
    }
}
