package leetcode_21_merge_two_sorted_lists

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val result = ListNode(-1)
        var current: ListNode? = result
        var li1: ListNode? = l1
        var li2: ListNode? = l2
        while (li1 != null || li2 != null) {
            if (li1?.`val` == null || (li2 != null && li2.`val` <= li1.`val`)) {
                current?.next = li2
                current = current?.next
                li2 = li2?.next
            } else if (li2?.`val` == null || li1.`val` <= li2.`val`) {
                current?.next = li1
                current = current?.next
                li1 = li1.next
            }
        }

        return result.next
    }

    fun mergeTwoLists(l: IntArray, r: IntArray): IntArray {
        var left = 0
        var right = 0
        val sorted = IntArray(l.size + r.size)

        for (i in sorted.indices) {
            if (left >= l.size || (right < r.size && r[right] <= l[left])) {
                sorted[i] = r[right]
                ++right
            } else if (right >= r.size || (left < l.size && l[left] <= r[right])) {
                sorted[i] = l[left]
                ++left
            }
        }

        return sorted
    }
}

fun main() {
    val l = intArrayOf(1, 2, 3)
    val r = intArrayOf(2, 4, 6)
    Solution().mergeTwoLists(l, r).forEach {
        println(it)
    }
}