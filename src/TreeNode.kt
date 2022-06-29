class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun equals(other: Any?): Boolean {
        if (other !is TreeNode) {
            return false
        }
        return compareTree(other)
    }

    private fun compareTree(other: TreeNode?): Boolean {
        if (`val` != other?.`val`) {
            return false
        }
        val isLeftEqual = left?.compareTree(other.left) ?: (other.left == null)
        val isRightEqual = right?.compareTree(other.right) ?: (other.right == null)
        return isLeftEqual == isRightEqual
    }

    companion object {
        fun create(vararg values: Int?): TreeNode? {
            if (values.isEmpty()) {
                return null
            }

            val nodeArray = Array<TreeNode?>(values.size) { null }
            for (i in values.indices) {
                val nodeValue = values[i]
                if (nodeArray[i] == null && nodeValue != null) {
                    nodeArray[i] = TreeNode(nodeValue)
                }
                val leftValue = values.getOrNull(2*i + 1)
                val rightValue = values.getOrNull(2*i + 2)
                var leftNode: TreeNode? = null
                if (leftValue != null) {
                    leftNode = TreeNode(leftValue)
                    nodeArray[2*i+1] = leftNode
                }

                var rightNode: TreeNode? = null
                if (rightValue != null) {
                    rightNode = TreeNode(rightValue)
                    nodeArray[2*i+2] = rightNode
                }
                nodeArray[i]?.left = leftNode
                nodeArray[i]?.right = rightNode
            }
            return nodeArray[0]
        }
    }
}