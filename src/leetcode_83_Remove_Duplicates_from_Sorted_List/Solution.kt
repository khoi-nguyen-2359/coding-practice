package leetcode_83_Remove_Duplicates_from_Sorted_List

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
    fun deleteDuplicates(head: LcLinkedListNode?): LcLinkedListNode? {
        var curr = head
        var prev: LcLinkedListNode? = null
        while (curr != null) {
            if (curr.`val` == prev?.`val`) {
                prev.next = curr.next
            } else {
                prev = curr
            }
            curr = curr.next
        }
        return head
    }
}