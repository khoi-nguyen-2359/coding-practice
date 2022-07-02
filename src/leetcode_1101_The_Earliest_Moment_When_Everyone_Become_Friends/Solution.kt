package leetcode_1101_The_Earliest_Moment_When_Everyone_Become_Friends

import kotlin.test.assertEquals

class Solution {
    fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
        logs.sortBy { it[0] }
        val groupOfPerson = mutableMapOf<Int, Int>()
        var groupCount = 0
        var groupId = 0
        for (i in logs.indices) {
            val g1 = groupOfPerson[logs[i][1]]
            val g2 = groupOfPerson[logs[i][2]]
            when {

                // both are not in any group -> add to a new same group
                g1 == null && g2 == null -> {
                    ++groupId
                    groupOfPerson[logs[i][1]] = groupId
                    groupOfPerson[logs[i][2]] = groupId
                    ++groupCount
                }

                // add one to the other's group
                g1 == null || g2 == null -> {
                    val g = g1 ?: g2 ?: 0
                    groupOfPerson[logs[i][1]] = g
                    groupOfPerson[logs[i][2]] = g
                }

                // merge group
                g1 != g2 -> {
                    groupOfPerson.forEach {
                        if (it.value == g1) {
                            groupOfPerson[it.key] = g2
                        }
                    }
                    --groupCount
                }
            }

            if (groupOfPerson.size == n && groupCount == 1) {
                return logs[i][0]
            }
        }

        return -1
    }
}

class SolutionDSU {
    fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
        logs.sortBy { it[0] }
        val dsu = DSU(n)
        var group = n
        for (log in logs) {
            if (dsu.union(log[1], log[2])) {
                --group
            }

            if (group == 1) {
                return log[0]
            }
        }

        return -1
    }

    class DSU(n: Int) {
        private val parent = IntArray(n) { index -> index }
        private val rank = IntArray(n) { 0 }

        fun find(a: Int): Int {
            var curr = a
            while (parent[curr] != curr) {
                parent[curr] = parent[parent[curr]]
                curr = parent[curr]
            }
            parent[a] = curr
            return curr
        }

        fun union(a: Int, b: Int): Boolean {
            val pa = find(a)
            val pb = find(b)
            if (pa == pb) {
                return false
            }

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb
            } else {
                parent[pb] = pa
                if (rank[pa] == rank[pb]) {
                    ++rank[pa]
                }
            }

            return true
        }
    }
}

fun main() {
    arrayOf(
            arrayOf(intArrayOf(20190101, 0, 1), intArrayOf(20190104, 3, 4), intArrayOf(20190107, 2, 3), intArrayOf(20190211, 1, 5), intArrayOf(20190224, 2, 4), intArrayOf(20190301, 0, 3), intArrayOf(20190312, 1, 2), intArrayOf(20190322, 4, 5)) to 6 to 20190301,
            arrayOf(intArrayOf(0, 2, 0), intArrayOf(1, 0, 1), intArrayOf(3, 0, 3), intArrayOf(4, 1, 2), intArrayOf(7, 3, 1)) to 4 to 3,
            arrayOf(intArrayOf(9, 3, 0), intArrayOf(0, 2, 1), intArrayOf(8, 0, 1), intArrayOf(1, 3, 2), intArrayOf(2, 2, 0), intArrayOf(3, 3, 1)) to 4 to 2,
            arrayOf(intArrayOf(5, 4, 3), intArrayOf(2, 0, 4), intArrayOf(1, 1, 2), intArrayOf(0, 0, 2), intArrayOf(9, 1, 3), intArrayOf(3, 1, 4), intArrayOf(8, 2, 4), intArrayOf(6, 1, 0)) to 5 to 5,
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().earliestAcq(input.first, input.second))
        assertEquals(exp, SolutionDSU().earliestAcq(input.first, input.second))
    }
}