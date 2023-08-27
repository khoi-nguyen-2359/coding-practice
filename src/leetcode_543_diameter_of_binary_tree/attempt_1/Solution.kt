package leetcode_543_diameter_of_binary_tree.attempt_1

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private var diameter = 0
    private fun findLongestPath(node: TreeNode?): Int {
        if (node == null)
            return 0

        val leftDistance = findLongestPath(node.left)
        val rightDistance = findLongestPath(node.right)

        diameter = Math.max(diameter, leftDistance + rightDistance)

        return Math.max(leftDistance, rightDistance) + 1
    }

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        diameter = 0
        findLongestPath(root)
        return diameter
    }
}

fun main() {
    val root = TreeNode(1).also {
        it.left = TreeNode(1)
        it.right = TreeNode(1).also {
            it.left = TreeNode(1)
            it.right = TreeNode(1)
        }
    }
    val res = Solution().diameterOfBinaryTree(root)
    println(res)
}