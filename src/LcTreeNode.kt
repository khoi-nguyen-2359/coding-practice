import java.util.LinkedList
import java.util.Stack

/**
 * Common class for TreeNode in leetcode problems.
 */
class LcTreeNode(var `val`: Int) {
    var left: LcTreeNode? = null
    var right: LcTreeNode? = null

    override fun toString(): String {
        return "$`val`"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is LcTreeNode) {
            return false
        }
        return compareTree(other)
    }

    fun printAllPaths() {
        val stack = Stack<Pair<LcTreeNode, Int>>()
        stack.add(this to 2)
        while (stack.isNotEmpty()) {
            val (node, state) = stack.pop()
            if (state == 0) {
                if (node.left == null && node.right == null) {
                    stack.forEach { print("${it.first.`val`}-") }
                    println("${node.`val`}")
                }
            } else {
                val nextChild = if (state == 2) {
                    node.left
                } else if (state == 1) {
                    node.right
                } else null

                stack.push(node to state - 1)
                if (nextChild != null) {
                    stack.push(nextChild to 2)
                }
            }
        }
    }

    private fun compareTree(other: LcTreeNode?): Boolean {
        if (`val` != other?.`val`) {
            return false
        }
        val isLeftEqual = left?.compareTree(other.left) ?: (other.left == null)
        val isRightEqual = right?.compareTree(other.right) ?: (other.right == null)
        return isLeftEqual && isRightEqual
    }

    companion object {
        fun create(vararg values: Int?): LcTreeNode? {
            if (values.isEmpty()) {
                return null
            }
            val nodeArray = Array<LcTreeNode?>(values.size) { null }
            for (i in values.indices) {
                val nodeValue = values[i]
                if (nodeArray[i] == null && nodeValue != null) {
                    nodeArray[i] = LcTreeNode(nodeValue)
                }
                val leftValue = values.getOrNull(2 * i + 1)
                val rightValue = values.getOrNull(2 * i + 2)
                var leftNode: LcTreeNode? = null
                if (leftValue != null) {
                    leftNode = LcTreeNode(leftValue)
                    nodeArray[2 * i + 1] = leftNode
                }

                var rightNode: LcTreeNode? = null
                if (rightValue != null) {
                    rightNode = LcTreeNode(rightValue)
                    nodeArray[2 * i + 2] = rightNode
                }
                nodeArray[i]?.left = leftNode
                nodeArray[i]?.right = rightNode
            }
            return nodeArray[0]
        }
    }
}