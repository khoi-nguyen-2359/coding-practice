package misc_block_distances

import kotlin.test.assertEquals

class Solution {
    fun solve(types: List<String>, blocks: List<Map<String, Boolean>>): Int {
        val distanceList = List(blocks.size) { index ->
            val item = mutableMapOf<String, Int>()
            types.forEach { t ->
                item[t] = if (blocks[index][t] == true) {
                    0
                } else {
                    Int.MAX_VALUE
                }
            }
            item
        }

        for (i in 1 until blocks.size) {
            types.forEach { t ->
                val prevDistance = if (distanceList[i - 1][t] == Int.MAX_VALUE) {
                    Int.MAX_VALUE
                } else {
                    (distanceList[i-1][t] ?: 0) + 1
                }
                val currDistance = distanceList[i][t] ?: 0
                distanceList[i][t] = Math.min(prevDistance, currDistance)
            }
        }

        for (i in blocks.size - 2 downTo 0) {
            types.forEach { t ->
                val prevDistance = if (distanceList[i + 1][t] == Int.MAX_VALUE) {
                    Int.MAX_VALUE
                } else {
                    (distanceList[i + 1][t] ?: 0) + 1
                }
                val currDistance = distanceList[i][t] ?: 0
                distanceList[i][t] = Math.min(prevDistance, currDistance)
            }
        }

        val ans = distanceList[0]
        var ansMax = 0
        ans.forEach {
            ansMax = Math.max(it.value, ansMax)
        }
        var ansIndex = 0
        for (i in 1 until distanceList.size) {
            var distanceMax = 0
            types.forEach { t ->
                val disOfT = distanceList[i][t] ?: return@forEach
                distanceMax = Math.max(disOfT, distanceMax)
            }
            if (ansMax > distanceMax) {
                ansMax = distanceMax
                ansIndex = i
            }
        }

        return ansIndex
    }
}

fun main() {
    arrayOf(
            listOf("gym", "school", "store") to listOf(
                    mapOf(
                            "gym" to false,
                            "school" to true,
                            "store" to false,
                    ),
                    mapOf(
                            "gym" to true,
                            "school" to false,
                            "store" to false,
                    ),
                    mapOf(
                            "gym" to true,
                            "school" to true,
                            "store" to false,
                    ),
                    mapOf(
                            "gym" to false,
                            "school" to true,
                            "store" to false,
                    ),
                    mapOf(
                            "gym" to false,
                            "school" to true,
                            "store" to true,
                    ),
            ) to 3
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().solve(input.first, input.second))
    }
}

/*
Blocks = [
{
    "gym": false,       =>  posinf      => 1
    "school": true,     => 0            => 0
    "store": false,     => posinf       => 4
},
{
    "gym": true,        =>  0           => 0
    "school": false,    => 1            => 1
    "store": false,     => posinf       => 3
},
{
    "gym": true,        => 0            => 0
    "school": true,     => 0            => 0
    "store": false,     => posinf       => 2
},
{
    "gym": false,       => 1            => 1
    "school": true,     => 0            => 0
    "store": false,     => posinf       => 1
},
{
    "gym": false,       => 2            => 2
    "school": true,     => 0            => 0
    "store": true,      => 0            => 0
},
]

Types = ["gym", "school", "store"]
 */