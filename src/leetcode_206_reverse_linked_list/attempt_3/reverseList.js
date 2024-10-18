/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 * 
 * 1 -> 2 -> 3 -> 4
 * 1 <- 2 <- 3 <- 4
 */
const { ListNode, LinkedList } = require("../../LcListNode")

var reverseList = function (head) {
    var prev = null
    var curr = head
    while (curr) {
        var tmpNext = curr.next
        curr.next = prev
        prev = curr
        curr = tmpNext
    }
    return prev
};

[
    { inp: [1, 2, 3, 4], outp: [4, 3, 2, 1] },
    { inp: [1, 2], outp: [2, 1] },
    { inp: [1], outp: [1] },
    { inp: [], outp: [] },
].forEach(testcase => {
    let head = LinkedList(...testcase.inp)
    head.logList()
    var reversed = reverseList(head)
    reversed.logList()
})
