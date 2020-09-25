package leetcode_234_palindrome_linked_list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var front = head
        var back = head
        var backPrev: ListNode? = null
        while (front?.next != null && back != null) {
            front = front.next?.next
            val backNext = back.next
            back.next = backPrev
            backPrev = back
            back = backNext
        }

        if (front == null) {
            front = back
        } else {
            front = back?.next
        }
        back = backPrev

        while (front != null) {
            if (back?.`val` != front.`val`) {
                return false
            }

            front = front.next
            back = back.next
        }

        return true
    }
}