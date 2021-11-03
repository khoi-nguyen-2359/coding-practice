package leetcode_129_sum_root_to_leaf

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private var sum = 0
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        sum = 0
        traverseRecursive(0, root)
        return sum
    }

    private fun traverseRecursive(accum: Int, root: TreeNode) {
        val left = root.left
        val right = root.right
        if (left != null) {
            traverseRecursive(accum * 10 + root.`val`, left)
        }
        if (right != null) {
            traverseRecursive(accum * 10 + root.`val`, right)
        }
        if (left == null && right == null) {
            sum += accum * 10 + root.`val`
        }
    }
}