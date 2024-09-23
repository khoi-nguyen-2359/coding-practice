package leetcode_142_Linked_List_Cycle_II

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
    fun detectCycle(head: LcLinkedListNode?): LcLinkedListNode? {
        val intersectPoint = intersectPoint(head)
                ?: return null

        var p1 = head
        var p2: LcLinkedListNode? = intersectPoint
        while (p1 != p2) {
            p1 = p1?.next
            p2 = p2?.next
        }
        return p1
    }

    private fun intersectPoint(head: LcLinkedListNode?): LcLinkedListNode? {
        var slow = head
        var fast = head
        do {
            slow = slow?.next
            fast = fast?.next?.next
        } while (slow != fast && slow != null)

        return slow
    }
}

fun main() {
    val head = LcLinkedListNode.create(1,2,3,4)
    head?.next?.next?.next?.next = head?.next?.next
    Solution().detectCycle(head)?.`val`?.let(::println)
}

/*
          |========C=======|
-3 -2 -1 [0] 1 [2] 3 4 -> [0]
|====F====|==a==|=====b====|

D = 2d
F + nC + a = 2 (F + a)
nC = F + a
F = nC - a
 */