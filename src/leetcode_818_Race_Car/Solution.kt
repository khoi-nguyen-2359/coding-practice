package leetcode_818_Race_Car

import java.util.Deque
import java.util.LinkedList


class Solution {
    fun racecar(target: Int): Int {
        val queue: Deque<Pair<Int, Int>> = LinkedList()
        val visited = HashSet<Pair<Int, Int>>()

        //pos, speed
        queue.add(0 to 1)
        visited.add(0 to 1)

        var ans = 0
        while (queue.isNotEmpty()) {
            val queueSize = queue.size
            println("size=$queueSize")
            for (i in 0 until queueSize) {
                val (pos, speed) = queue.pollFirst()
                if (pos < 0 || pos >= target * 2) {
                    continue
                }
                if (pos == target) {
                    return ans
                }
                val A = pos + speed to speed * 2
                val R = pos to if (speed > 0) -1 else 1
                if (!visited.contains(A)) {
                    queue.addLast(A)
                    visited.add(A)
                }
                if (!visited.contains(R)) {
                    queue.addLast(R)
                    visited.add(R)
                }
            }
            ++ans
        }
        return ans
    }
}

class Node(val pair: Pair<Int, Int>, val next: Node? = null) {
    fun print() {
        var curr: Node? = this
        while (curr != null) {
            print("${curr.pair}")
            curr = curr.next
            if (curr != null) {
                print("->")
            }
        }
    }
}

fun main() {
    Solution().racecar(6).let(::println)
}

/*
Input: 6
Output: AAARA
pos: 1  3   7   7   6

input: 5
out:
A A R A R A A
1 3 3 2 2 3 5

inp: 13
out: A A A A R A A R A

pos = pos + 1 + 2 + 4 + 8 + 16 + 32 + ... + 2^n = target
pos = pos - 1 - 2 - 4 - 8 - 16 - 32
speed *= 2
 */