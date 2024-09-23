package leetcode_2_add_two_nums.attempt_2

import LcLinkedListNode
import kotlin.test.assertTrue

class Solution {
    fun addTwoNumbers(l1: LcLinkedListNode?, l2: LcLinkedListNode?): LcLinkedListNode? {
        val result = LcLinkedListNode(-1)
        var c1 = l1
        var c2 = l2
        var c3: LcLinkedListNode? = result
        var carry = 0
        while (c1 != null || c2 != null) {
            val s = (c1?.`val` ?: 0) + (c2?.`val` ?: 0) + carry
            val tmp = LcLinkedListNode(s % 10)
            c3?.next = tmp
            c3 = tmp
            carry = s / 10
            c1 = c1?.next
            c2 = c2?.next
        }
        if (carry > 0) {
            c3?.next = LcLinkedListNode(carry)
        }
        return result.next
    }
}

fun main() {
    arrayOf(
            LcLinkedListNode.create(2, 4, 3) to LcLinkedListNode.create(5, 6, 4) to LcLinkedListNode.create(7, 0, 8),
            LcLinkedListNode.create(0) to LcLinkedListNode.create(0) to LcLinkedListNode.create(0),
            LcLinkedListNode.create(9, 9, 9, 9, 9, 9, 9) to LcLinkedListNode.create(9, 9, 9, 9) to LcLinkedListNode.create(8, 9, 9, 9, 0, 0, 0, 1),
            LcLinkedListNode.create(9, 9, 9, 9, 9, 9, 9) to LcLinkedListNode.create(0) to LcLinkedListNode.create(9, 9, 9, 9, 9, 9, 9),
    ).forEach {
        assertTrue(it.second?.isEqual(Solution().addTwoNumbers(it.first.first, it.first.second)) == true)
    }
}