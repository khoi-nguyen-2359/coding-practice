package leetcode_234_palindrome_linked_list.attempt_3

import LcLinkedListNode

class Solution {
    fun isPalindrome(head: LcLinkedListNode?): Boolean {
        val reversedHead = reverse(head)
        var currOriginal = head
        var currReversed = reversedHead
        while (currOriginal != null && currReversed != null) {
            if (currOriginal.`val` != currReversed.`val`) {
                return false
            }

            currOriginal = currOriginal.next
            currReversed = currReversed.next
        }

        return true
    }

    private fun reverse(head: LcLinkedListNode?): LcLinkedListNode? {
        var curr = head
        var next: LcLinkedListNode? = null
        while (curr != null) {
            val node = LcLinkedListNode(curr.`val`)
            node.next = next
            next = node
            curr = curr.next
        }
        return next
    }
}

class SolutionInPlace {
    fun isPalindrome(node: LcLinkedListNode?): Boolean {
        // find the second half's head
        var secondHead = node
        var i = node
        while (i != null) {
            secondHead = secondHead?.next
            i = i.next?.next
        }

        // reverse the second half
        var reversedSecondHead: LcLinkedListNode? = null
        i = secondHead
        while (i != null) {
            val tmp = i.next
            i.next = reversedSecondHead
            reversedSecondHead = i
            i = tmp
        }

        // compare the reversed second half with the first half
        i = reversedSecondHead
        var j = node
        while (i != null && j != null) {
            if (i.`val` != j.`val`) {
                return false
            }
            i = i.next
            j = j.next
        }
        return true
    }
}