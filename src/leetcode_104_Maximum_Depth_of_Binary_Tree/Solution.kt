package leetcode_104_Maximum_Depth_of_Binary_Tree

import TreeNode
import java.util.Stack

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val stack = Stack<Pair<TreeNode, Int>>()
        stack.push(root to 1)
        var max = 1
        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            val (node, level) = pop
            if (node.left == null && node.right == null) {
                if (level > max) {
                    max = level
                }
            } else {
                node.left?.let {
                    stack.push(it to level + 1)
                }
                node.right?.let {
                    stack.push(it to level + 1)
                }
            }
        }

        return max
    }
}
