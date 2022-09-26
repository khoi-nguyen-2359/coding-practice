package leetcode_2_add_two_nums_2

import ListNode
import kotlin.test.assertTrue

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val result = ListNode(-1)
        var c1 = l1
        var c2 = l2
        var c3: ListNode? = result
        var carry = 0
        while (c1 != null || c2 != null) {
            val s = (c1?.`val` ?: 0) + (c2?.`val` ?: 0) + carry
            val tmp = ListNode(s % 10)
            c3?.next = tmp
            c3 = tmp
            carry = s / 10
            c1 = c1?.next
            c2 = c2?.next
        }
        if (carry > 0) {
            c3?.next = ListNode(carry)
        }
        return result.next
    }
}

fun main() {
    arrayOf(
            ListNode.create(2, 4, 3) to ListNode.create(5, 6, 4) to ListNode.create(7, 0, 8),
            ListNode.create(0) to ListNode.create(0) to ListNode.create(0),
            ListNode.create(9, 9, 9, 9, 9, 9, 9) to ListNode.create(9, 9, 9, 9) to ListNode.create(8, 9, 9, 9, 0, 0, 0, 1),
            ListNode.create(9, 9, 9, 9, 9, 9, 9) to ListNode.create(0) to ListNode.create(9, 9, 9, 9, 9, 9, 9),
    ).forEach {
        assertTrue(it.second?.isEqual(Solution().addTwoNumbers(it.first.first, it.first.second)) == true)
    }
}