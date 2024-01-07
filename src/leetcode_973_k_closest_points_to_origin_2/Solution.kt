package leetcode_973_k_closest_points_to_origin_2

import java.util.PriorityQueue

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pQueue = PriorityQueue<IntArray>(k) { i1, i2 ->
            i2[0] * i2[0] + i2[1] * i2[1] - i1[0] * i1[0] - i1[1] * i1[1]
        }
        // O(n)
        points.forEach { p ->
            if (pQueue.size >= k) {
                val peek = pQueue.peek()
                if (p[0] * p[0] + p[1] * p[1] >= peek[0] * peek[0] + peek[1] * peek[1]) {
                    return@forEach
                }
                pQueue.poll() // O(logk)
            }
            pQueue.add(p) // O(logk)
        } // => O(n*logk)
        return Array(k) { pQueue.poll() } // O(k)
    } // => O(n*logk + k)
}

fun main() {
    arrayOf(
        arrayOf(intArrayOf(1,3), intArrayOf(-2,2)) to 1,
        arrayOf(intArrayOf(3,3), intArrayOf(5,-1), intArrayOf(-2,4)) to 2,
    ).forEach { (points, k) ->
        val res = Solution().kClosest(points, k)
        res.forEach {
            println("${it[0]}, ${it[1]}")
        }
        println()
    }
}
