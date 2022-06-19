package misc_priority_queue

import java.util.concurrent.atomic.AtomicLong

class WorkQueue {
    private val capacity = 100
    private val data = Array(capacity) { FIFOEntry(Entry("", -1)) }
    private var size = 0

    fun add(work: String, priority: Int) {
        val entry = FIFOEntry(Entry(work, priority))
        data[size++] = entry
        shiftUp(size - 1)
    }

    fun poll(): String? {
        if (size == 0) {
            return null
        }
        val top = data[0]
        data[0] = data[--size]
        heapify(0)
        return top.entry.work
    }

    private fun heapify(index: Int) {
        var swapIndex = index
        val left = left(index)
        val right = right(index)
        if (left < size && data[swapIndex] < data[left]) {
            swapIndex = left
        }
        if (right < size && data[swapIndex] < data[right]) {
            swapIndex = right
        }
        if (swapIndex != index) {
            swap(index, swapIndex)
            heapify(swapIndex)
        }
    }

    private fun shiftUp(index: Int) {
        var curr = index
        var parent = parent(curr)
        while (parent >= 0 && data[parent] < data[curr]) {
            swap(curr, parent)
            curr = parent
            parent = parent(curr)
        }
    }

    private fun swap(i: Int, j: Int) {
        val tmp = data[i]
        data[i] = data[j]
        data[j] = tmp
    }

    fun println() {
        for (i in 0 until size) {
            print("${data[i].entry.work} ")
        }
        kotlin.io.println()
    }

    // parent: i
    // => left child = 2 * i + 1 -> parent = (left - 1) / 2 = l / 2 - 1/2
    // => right child = 2 * i + 2 -> parent = (right - 2) / 2  = r/2 - 1
    // => parent = (child - 1) / 2
    private fun parent(child: Int): Int = (child - 1) / 2
    private fun right(parent: Int): Int = 2 * parent + 2
    private fun left(parent: Int): Int = 2 * parent + 1

    class FIFOEntry<T : Comparable<T>>(val entry: T) : Comparable<FIFOEntry<T>> {
        private val seqNum: Long = seq.getAndIncrement()

        override infix operator fun compareTo(other: FIFOEntry<T>): Int {
            val result = entry.compareTo(other.entry)
            if (result != 0) {
                return result
            }
            return (seqNum - other.seqNum).toInt() * -1
        }

        companion object {
            private val seq: AtomicLong = AtomicLong()
        }
    }

    class Entry(val work: String, val priority: Int) : Comparable<Entry> {
        override infix operator fun compareTo(other: Entry): Int = priority - other.priority
    }
}

fun main() {
    val workQueue = WorkQueue()
    workQueue.add("work00-0", 0)
    workQueue.add("work03", 3)
    workQueue.add("work01", 1)
    workQueue.add("work00-1", 0)
    workQueue.add("work02-0", 2)
    workQueue.add("work00-2", 0)
    workQueue.add("work00-3", 0)
    workQueue.add("work02-1", 2)
    workQueue.add("work04", 4)

    var curr = workQueue.poll()
    while (curr != null) {
        println(curr)
        curr = workQueue.poll()
    }
}