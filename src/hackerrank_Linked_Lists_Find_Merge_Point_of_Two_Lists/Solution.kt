package hackerrank_Linked_Lists_Find_Merge_Point_of_Two_Lists

import java.io.BufferedWriter
import java.io.FileWriter
import java.util.*
import kotlin.math.abs

class SinglyLinkedListNode(nodeData: Int) {
    public var data: Int
    public var next: SinglyLinkedListNode?

    init {
        data = nodeData
        next = null
    }
}

class SinglyLinkedList {
    public var head: SinglyLinkedListNode?
    public var tail: SinglyLinkedListNode?

    init {
        head = null
        tail = null
    }

    public fun insertNode(nodeData: Int) {
        var node = SinglyLinkedListNode(nodeData)

        if (head == null) {
            head = node
        } else {
            tail?.next = node
        }

        tail = node
    }

}


// Complete the findMergeNode function below.
/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
fun findMergeNode(head1: SinglyLinkedListNode?, head2: SinglyLinkedListNode?): Int {
    return SolutionShorterLength().findMergeNodeAtShorterLength(head1, head2)
}

class SolutionShorterLength {
    fun findMergeNodeAtShorterLength(head1: SinglyLinkedListNode?, head2: SinglyLinkedListNode?): Int {
        val len1 = len(head1)
        val len2 = len(head2)
        var (startLonger: SinglyLinkedListNode?, startShorter: SinglyLinkedListNode?) = if (len1 > len2) {
            head1 to head2
        } else {
            head2 to head1
        }
        repeat(abs(len1 - len2)) {
            startLonger = startLonger?.next
        }
        while (startLonger != null && startShorter != null) {
            if (startLonger === startShorter) {
                return startShorter.data
            }
            startLonger = startLonger?.next
            startShorter = startShorter.next
        }

        return -1
    }

    fun len(head1: SinglyLinkedListNode?): Int {
        var len = 0
        var curr = head1
        while (curr != null) {
            ++len
            curr = curr.next
        }
        return len
    }
}

class SolutionWithMarking {
    fun findMergeNodeWithMarking(head1: SinglyLinkedListNode?, head2: SinglyLinkedListNode?): Int {
        val traversed = mutableSetOf<SinglyLinkedListNode>()
        return traverse(head1, traversed)?.data
            ?: traverse(head2, traversed)?.data
            ?: -1
    }

    fun traverse(head1: SinglyLinkedListNode?, traversedSet: MutableSet<SinglyLinkedListNode>): SinglyLinkedListNode? {
        var curr = head1
        while (curr != null) {
            if (traversedSet.contains(curr)) {
                return curr
            } else {
                traversedSet.add(curr)
            }
            curr = curr.next
        }
        return null
    }
}

private val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    val bufferedWriter = BufferedWriter(FileWriter(System.getenv("OUTPUT_PATH")))
    val tests = scanner.nextInt()
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
    for (testsItr in 0 until tests) {
        val index = scanner.nextInt()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        val llist1 = SinglyLinkedList()
        val llist1Count = scanner.nextInt()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (i in 0 until llist1Count) {
            val llist1Item = scanner.nextInt()
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
            llist1.insertNode(llist1Item)
        }
        val llist2 = SinglyLinkedList()
        val llist2Count = scanner.nextInt()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (i in 0 until llist2Count) {
            val llist2Item = scanner.nextInt()
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
            llist2.insertNode(llist2Item)
        }
        var ptr1 = llist1.head
        var ptr2 = llist2.head
        for (i in 0 until llist1Count) {
            if (i < index) {
                ptr1 = ptr1!!.next
            }
        }
        for (i in 0 until llist2Count) {
            if (i != llist2Count - 1) {
                ptr2 = ptr2!!.next
            }
        }
        ptr2!!.next = ptr1
        val result = findMergeNode(llist1.head, llist2.head)
        bufferedWriter.write(result.toString())
        bufferedWriter.newLine()
    }
    bufferedWriter.close()
    scanner.close()
}
