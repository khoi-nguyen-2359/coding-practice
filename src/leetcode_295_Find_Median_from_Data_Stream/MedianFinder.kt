package leetcode_295_Find_Median_from_Data_Stream

import java.util.PriorityQueue

class MedianFinder {
    private val hi: PriorityQueue<Int> = PriorityQueue { t1, t2 ->
        t1 - t2
    }

    private val lo: PriorityQueue<Int> = PriorityQueue { t1, t2 ->
        t2 - t1
    }

    fun addNum(num: Int) {
        lo.add(num)
        hi.add(lo.peek())
        lo.poll()

        if (lo.size < hi.size) {
            lo.add(hi.peek())
            hi.poll()
        }
    }

    fun findMedian(): Double = if (hi.size > lo.size) {
        hi.peek().toDouble()
    } else if (hi.size < lo.size) {
        lo.peek().toDouble()
    } else {
        (lo.peek() + hi.peek().toDouble()) / 2
    }
}

fun main() {
    val medianFinder = MedianFinder()
    medianFinder.addNum(1) // arr = [1]
    medianFinder.addNum(2) // arr = [1, 2]

    medianFinder.findMedian().let(::println) // return 1.5 (i.e., (1 + 2) / 2)

    medianFinder.addNum(3) // arr[1, 2, 3]

    medianFinder.findMedian().let(::println) // return 2.0

    medianFinder.addNum(5) // arr[1, 2, 3, 5]

    medianFinder.findMedian().let(::println) // return 2.5

    medianFinder.addNum(0) // arr[0, 1, 2, 3, 5]
    medianFinder.findMedian().let(::println) // return 2.0

    medianFinder.addNum(9) // arr[0, 1, 2, 3, 5, 9]

    medianFinder.findMedian().let(::println) // return 2.5
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */