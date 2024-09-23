package leetcode_19_Remove_Nth_Node_From_End_of_List

import LcLinkedListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: LcLinkedListNode?, n: Int): LcLinkedListNode? {
        var fast = head
        var slow = head
        var prev = head
        var count = n - 1
        while (fast?.next != null) {
            fast = fast.next
            if (count == 0) {
                prev = slow
                slow = slow?.next
            } else {
                --count
            }
        }

        if (slow === head) {
            return head?.next
        }
        prev?.next = slow?.next
        return head
    }
}

fun main() {
    arrayOf(
            LcLinkedListNode.create(1, 2) to 2,
            LcLinkedListNode.create(1, 2, 3, 4, 5) to 2,
            LcLinkedListNode.create(1) to 1,
    ).forEach { (node, nth) ->
        Solution().removeNthFromEnd(node, nth)?.print()
        println()
    }
}
/*
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

init:
fast: 1     count: 1    slow: 1

fast: 2     count: 0    slow: 1
fast: 3     count: 0    slow: 2
..
fast: 5     slow:4
 */