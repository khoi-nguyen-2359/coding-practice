package leetcode_134_Gas_Station

import kotlin.test.assertEquals

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var station = 0
        var carGas = 0
        var i = 0
        do {
            carGas += gas[i % gas.size] - cost[i % gas.size]
            while (carGas < 0) {
                carGas -= gas[station] - cost[station]
                ++station

                if (station >= gas.size) {
                    return -1
                }
            }

            ++i
        } while (i < gas.size || station != i % gas.size)

        return station
    }
}

fun main() {
    arrayOf(
//            intArrayOf(1,2,3,4,5) to intArrayOf(3,4,5,1,2) to 3,
            intArrayOf(1,2,3,4,5,5,70) to intArrayOf(2,3,4,3,9,6,2) to 6,
//            intArrayOf(2,3,4) to intArrayOf(3,4,3) to -1
    ).forEach { (inp, exp) ->
        assertEquals(exp, Solution().canCompleteCircuit(inp.first, inp.second))
    }
}