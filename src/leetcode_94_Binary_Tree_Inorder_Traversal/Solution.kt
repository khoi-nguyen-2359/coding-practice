package leetcode_94_Binary_Tree_Inorder_Traversal

import TreeNode

class Solution {
    private val result = mutableListOf<Int>()
    fun inorderTraversal(root: TreeNode?): List<Int> {
        doTraverse(root)
        return result
    }

    private fun doTraverse(node: TreeNode?) {
        node?.left?.let(::doTraverse)
        node?.`val`?.let(result::add)
        node?.right?.let(::doTraverse)
    }
}
