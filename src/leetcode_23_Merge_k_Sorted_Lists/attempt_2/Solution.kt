package leetcode_23_Merge_k_Sorted_Lists.attempt_2;

import ListNode

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var end = lists.size - 1
        while (end > 0) {
            for (i in 0 .. end step 2) {
                val merged = if (i == end) {
                    lists[i]
                } else {
                    mergeTwoLists(lists[i], lists[i + 1])
                }
                lists[i / 2] = merged
            }
            end /= 2
        }
        return lists.firstOrNull()
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
//        l1?.print()
//        println()
//        l2?.print()
//        println()
        var c1 = l1
        var c2 = l2
        val merged = ListNode(-1)
        var c: ListNode? = merged
        while (c != null) {
            if ((c1?.`val` ?: Int.MAX_VALUE) <= (c2?.`val` ?: Int.MAX_VALUE)) {
                c.next = c1
                c1 = c1?.next
            } else if ((c2?.`val` ?: Int.MAX_VALUE) <= (c1?.`val` ?: Int.MAX_VALUE)) {
                c.next = c2
                c2 = c2?.next
            }
            c = c.next
        }
//        merged.next?.print()
//        println()
        return merged.next
    }
}

fun main() {
    arrayOf(
            arrayOf(
                    ListNode.create(1,4,5),
                    ListNode.create(1,3,4),
                    ListNode.create(2,6),
            ),
            arrayOf(),
            emptyArray()
    ).forEach {
        Solution().mergeKLists(it)?.print()
    }
}