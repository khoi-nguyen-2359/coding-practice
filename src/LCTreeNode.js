class LcTreeNode {

    constructor(val, left, right) {
        this.val = val
        this.left = left
        this.right = right
    }

    static TreeNode(val, left, right) {
        return new LcTreeNode(val, left, right)
    }
}

exports.TreeNode = LcTreeNode.TreeNode