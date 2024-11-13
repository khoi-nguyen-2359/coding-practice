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
 * @return {number[]}
 */

const { TreeNode, from } = require('../LCTreeNode')

var averageOfLevels = function (root) {
    var queue = [root]
    var result = [root.val]
    var level = [] // space complexity?
    while (queue.length > 0) {
        var sum = 0
        for (var i = 0; i < queue.length; ++i) {
            if (queue[i].left) {
                level.push(queue[i].left)
                sum += queue[i].left.val
            }
            if (queue[i].right) {
                level.push(queue[i].right)
                sum += queue[i].right.val
            }
        }
        if (level.length > 0) {
            result.push(sum / level.length)
        }
        queue = level
        level = []
    }

    return result
};

require('../TestLoop').testLoop([
    { root: from([3, 9, 20, null, null, 15, 7]), expect: [3, 14.5, 11] },
    { root: from([3, 9, 20, 15, 7]), expect: [3, 14.5, 11] }
], averageOfLevels)