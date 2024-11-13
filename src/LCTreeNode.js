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
        let nodes = values.map(v => {
            if (v) {
                return new LcTreeNode(v)
            } else {
                return null
            }
        })
        nodes.forEach((n, i) => {
            if (n) {
                n.left = nodes[2 * i + 1]
                n.right = nodes[2 * i + 2]
            }
        });
        return nodes[0]
    }
}

exports.TreeNode = LcTreeNode.TreeNode
exports.from = LcTreeNode.from