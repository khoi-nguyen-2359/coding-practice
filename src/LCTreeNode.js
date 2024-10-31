class LcTreeNode {

    constructor(val, left, right) {
        this.val = val
        this.left = left
        this.right = right
    }

    static TreeNode(val, left, right) {
        return new LcTreeNode(val, left, right)
    }

    static from(values) {
        let nodes = values.map(v => new LcTreeNode(v))
        nodes.forEach((n, i) => {
            n.left = nodes[2 * i + 1]
            n.right = nodes[2 * i + 2]
        });
        return nodes[0]
    }
}

exports.TreeNode = LcTreeNode.TreeNode
exports.from = LcTreeNode.from