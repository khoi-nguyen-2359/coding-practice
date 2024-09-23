package leetcode_445_Add_Two_Numbers_II

import LcLinkedListNode

class Solution {
    fun addTwoNumbers(l1: LcLinkedListNode?, l2: LcLinkedListNode?): LcLinkedListNode? {
        val stack1 = arrayListOf<Int>()
        val stack2 = arrayListOf<Int>()
        var curr = l1
        while (curr != null) {
            stack1.add(curr.`val`)
            curr = curr.next
        }
        curr = l2
        while (curr != null) {
            stack2.add(curr.`val`)
            curr = curr.next
        }

        var lastResult: LcLinkedListNode? = null
        var carrier = 0
        while (stack1.isNotEmpty() || stack2.isNotEmpty()) {
            val s1 = stack1.lastOrNull() ?: 0
            val s2 = stack2.lastOrNull() ?: 0
            var s = s1 + s2 + carrier
            carrier = s / 10
            s %= 10
            val next = lastResult
            lastResult = LcLinkedListNode(s)
            lastResult.next = next
            arrayOf(stack1, stack2).forEach {
                if (it.isNotEmpty()) {
                    it.removeAt(it.lastIndex)
                }
            }
        }

        if (carrier != 0) {
            val next = lastResult
            lastResult = LcLinkedListNode(carrier)
            lastResult.next = next
        }

        return lastResult
    }
}

class SolutionInPlace {
    fun addTwoNumbers(l1: LcLinkedListNode?, l2: LcLinkedListNode?): LcLinkedListNode? {
        val (rl1, length1) = reverse(l1)
        val (rl2, length2) = reverse(l2)
        var curr: LcLinkedListNode? = if (length1 > length2) {
            rl1
        } else {
            rl2
        }
        val result = curr
        var i = rl1
        var j = rl2
        var carrier = 0
        var prev: LcLinkedListNode? = null
        while (i != null || j != null) {
            val s1 = i?.`val` ?: 0
            val s2 = j?.`val` ?: 0
            var s = s1 + s2 + carrier
            carrier = s / 10
            s %= 10

            curr?.`val` = s
            prev = curr
            curr = curr?.next

            i = i?.next
            j = j?.next
        }

        if (carrier != 0) {
            prev?.next = LcLinkedListNode(carrier)
        }

        return reverse(result).first
    }

    private fun reverse(l: LcLinkedListNode?): Pair<LcLinkedListNode?, Int> {
        var curr: LcLinkedListNode? = l
        var next: LcLinkedListNode? = null
        var length = 0
        while (curr != null) {
            ++length
            val tmp = curr.next
            curr.next = next
            next = curr
            curr = tmp
        }
        return next to length
    }
}

fun main() {
    val l1 = LcLinkedListNode(7).apply {
        next = LcLinkedListNode(2).apply {
            next = LcLinkedListNode(4).apply {
                next = LcLinkedListNode(3)
            }
        }
    }
    val l2 = LcLinkedListNode(5).apply {
        next = LcLinkedListNode(6).apply {
            next = LcLinkedListNode(4)
        }
    }
    SolutionInPlace().addTwoNumbers(l1, l2)?.print()
}

/*
Input: l1 = [7,2,4,3], l2 = [5,6,4]
 */