package leetcode_2_add_two_nums.attempt_1

 class ListNode(var `val`: Int) {
     var next: ListNode? = null
 }

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) {
            return null
        }

        var i1 = l1
        var i2 = l2
        var i: ListNode? = ListNode(0)
        val result = i
        while (i1 != null || i2 != null) {
            var sum = (i1?.`val` ?: 0) + (i2?.`val` ?: 0) + (i?.`val` ?: 0)
            val carrier = sum / 10
            sum %= 10
            i?.`val` = sum

            i1 = i1?.next
            i2 = i2?.next

            if (i1 != null || i2 != null || carrier != 0) {
                i?.next = ListNode(carrier)
                i = i?.next
            }
        }

        return result
    }
}

fun main() {
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next?.next = ListNode(3)

    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next?.next = ListNode(4)

    Solution().addTwoNumbers(l1, l2).also {
        var c = it
        while (c != null) {
            println(c.`val`)
            c = c.next
        }
    }
}