/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

const { TreeNode, from } = require("../LCTreeNode")
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function (root1, root2) {
    const leafSequence = function (node, seq) {
        if (!node) {
            return
        }
        if (!node.left && !node.right) {
            seq.push(node.val)
            return
        }
        leafSequence(node.left, seq)
        leafSequence(node.right, seq)
    }
    let seq1 = []
    let seq2 = []
    leafSequence(root1, seq1)
    leafSequence(root2, seq2)
    console.log(seq1)
    console.log(seq2)
    return seq1.length == seq2.length && seq1.every((s1, i) => s1 == seq2[i])
};

[
    {
        root1: from([3,5,1,6,2,9,8,null,null,7,4]),
        root2: from([3,5,1,6,7,4,2,null,null,null,null,null,null,9,11,null,null,8,10]),
        output: true
    },
].forEach(testcase => {
    let res = leafSimilar(testcase.root1, testcase.root2)
    console.log(res == testcase.output)
})