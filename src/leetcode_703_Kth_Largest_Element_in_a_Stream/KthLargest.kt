package leetcode_703_Kth_Largest_Element_in_a_Stream

import java.util.PriorityQueue

class KthLargest(val k: Int, nums: IntArray) {

    private val queue = PriorityQueue<Int> { i1, i2 -> i1 - i2 }

    init {
        nums.forEach { add(it) }
    }

    fun add(`val`: Int): Int {
        queue.add(`val`)
        if (queue.size > k) {
            queue.poll()
        }
        return queue.peek()
                .also(::println)
    }
}

fun main() {
    val kthLargest = KthLargest(2, intArrayOf(0))
    kthLargest.add(-1);   // return 4
    kthLargest.add(1);   // return 5
    kthLargest.add(-2);  // return 5
    kthLargest.add(-4);   // return 8
    kthLargest.add(3);   // return 8
}