package leetcode_1029_Two_City_Scheduling

import java.lang.Math.abs

class Solution {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val cityA = mutableListOf<IntArray>()
        val cityB = mutableListOf<IntArray>()
        var cost = 0
        costs.forEach { c ->
            if (c[0] < c[1]) {
                cost += c[0]
                cityA.add(c)
            } else {
                cost += c[1]
                cityB.add(c)
            }
        }
        val diffSize = abs(cityA.size - cityB.size) / 2
        if (diffSize != 0) {
            val tmp1 = if (cityA.size > cityB.size) {
                cityA
            } else {
                cityB
            }
            tmp1.sortBy { abs(it[0] - it[1]) }
            repeat(diffSize) {
                cost += abs(tmp1[it][0] - tmp1[it][1])
            }
        }

        return cost
    }
}

class SolutionInPlace {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        var countA = 0
        var countB = 0
        var cost = 0
        var mark: Int
        costs.forEach { c ->
            if (c[0] < c[1]) {
                cost += c[0]
                ++countA
                mark = 1
            } else {
                cost += c[1]
                ++countB
                // mark as B city
                mark = -1
            }
            c[0] = abs(c[0] - c[1])
            c[1] = mark
        }
        val diffSize = abs(countA - countB) / 2
        if (diffSize != 0) {
            mark = if (countA > countB) {
                1
            } else {
                -1
            }
            costs.sortBy {
                if (it[1] == mark) {
                    it[0]
                } else {
                    Int.MAX_VALUE
                }
            }
            repeat(diffSize) {
                cost += costs[it][0]
            }
        }

        return cost
    }
}

fun main() {
    SolutionInPlace().twoCitySchedCost(
            arrayOf(
                    intArrayOf(259, 770),
                    intArrayOf(448, 54),
                    intArrayOf(926, 667),
                    intArrayOf(184, 139),
                    intArrayOf(840, 118),
                    intArrayOf(577, 469)
            )
    ).let(::println)
}
/*
[[259,770]   [448,54],    [926,667],      [184,139],  [840,118],      [577,469]]
A            B[abs=394]  B[abs=259]       B[abs=45]   B[abs=722]      B[abs=108]

A: [259,770] [184,139] [577,469]

 */