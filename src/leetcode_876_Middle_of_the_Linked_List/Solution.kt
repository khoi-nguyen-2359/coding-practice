package leetcode_876_Middle_of_the_Linked_List

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
    fun middleNode(head: LcLinkedListNode?): LcLinkedListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }
}

fun main() {
    arrayOf(
            LcLinkedListNode.create(1,2,3,4,5),
            LcLinkedListNode.create(1,2,3,4,5,6),
            LcLinkedListNode.create(1,2),
            LcLinkedListNode.create(1),
            null
    ).forEach {
        Solution().middleNode(it)?.`val`?.let(::println)
    }
}

/*
Input: head = [1,2,3,4,5]
(slow, fast) = (2,3)
(3, 5) -> stop

Input: head = [1,2,3,4,5,6]
(2, 3)  (3, 5)  (4, null)

Input: head = [1]
(null, null)
 */