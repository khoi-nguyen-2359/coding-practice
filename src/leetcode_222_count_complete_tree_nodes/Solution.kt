package leetcode_222_count_complete_tree_nodes

import LcBinTreeNode as TreeNode

// complexity: log(n) * log(n/2) ?
class Solution {
    fun countNodes(root: TreeNode?): Int {
        var leftMost: TreeNode? = root
            ?: return 0
        var treeHeight = 1
        while (leftMost?.left != null) {
            ++treeHeight
            leftMost = leftMost.left
        }
        var node = root
        var nodeIndex = 0
        var nodeHeight = 1
        while (node != null) {
            val midHeight = midNodeHeight(node, nodeHeight)
            if (midHeight == treeHeight) {
                node = node.right
                nodeIndex = nodeIndex * 2 + 2
            } else {
                node = node.left
                nodeIndex = nodeIndex * 2 + 1
            }
            ++nodeHeight
        }
        return if (nodeHeight - 1 == treeHeight) {
            (nodeIndex - 2) / 2
        } else {
            nodeIndex - 1
        } + 1
    }

    private fun midNodeHeight(node: TreeNode?, height: Int): Int {
        var right = node?.left
        var branchHeight = 0
        while (right != null) {
            ++branchHeight
            right = right.right
        }
        return height + branchHeight
    }
}