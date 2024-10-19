const { TreeNode } = require("../../LCTreeNode")

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */

var maxDepth = function (root) {
    if (!root) {
        return 0
    }

    return 1 + Math.max(
        maxDepth(root.left), 
        maxDepth(root.right)
    )
};

var node1 = TreeNode(1)
var node2 = TreeNode(2)
var node3 = TreeNode(3)
var node4 = TreeNode(4)
node1.left = node2
node1.right = node3
node3.left = node4

;

[
    { inp: node1, outp: 3 },
    { inp: node2, outp: 1 },
    { inp: node3, outp: 2 },
    { inp: node4, outp: 1 }
].forEach(testcase => {
    var res = maxDepth(testcase.inp)
    console.log(res, res === testcase.outp)
})