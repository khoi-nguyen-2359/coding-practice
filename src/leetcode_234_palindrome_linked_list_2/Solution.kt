package leetcode_234_palindrome_linked_list_2

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var mid: ListNode? = head ?: return false
        var tail: ListNode? = head
        while (tail?.next != null) {
            mid = mid?.next
            tail = tail.next?.next
        }
        tail = reverseLinkedList(mid)
        var p1 = head
        var p2 = tail
        while (p1 != null && p2 != null) {
            if (p1.`val` != p2.`val`) {
                return false
            }
            p1 = p1.next
            p2 = p2.next
        }

        return true
    }

    private fun reverseLinkedList(head: ListNode?): ListNode? {
        var p = head
        var prev: ListNode? = null
        while (p != null) {
            val tmp = p.next
            p.next = prev
            prev = p
            p = tmp
        }
        return prev
    }
}

fun main() {
    val head = ListNode(1).also {
        it.next = ListNode(2).also {
            it.next = ListNode(2).also {
                it.next = ListNode(1)
            }
        }
    }
    val res = Solution().isPalindrome(head)
    println(res)
}