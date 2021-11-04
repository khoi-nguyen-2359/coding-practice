package leetcode_404_sum_of_left_leaves

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private var sum = 0
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        sum = 0
        traverse(false, root)
        return sum
    }

    private fun traverse(isLeftChild: Boolean, node: TreeNode) {
        val left = node.left
        val right = node.right
        if (isLeftChild && left == null && right == null) {
            sum += node.`val`
        }
        if (left != null) {
            traverse(true, left)
        }
        if (right != null) {
            traverse(false, right)
        }
    }
}