package hackerrank_Organizing_Containers_of_Balls

import kotlin.test.assertEquals

/*
 * Complete the 'organizingContainers' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts 2D_INTEGER_ARRAY container as parameter.
 */

fun organizingContainers(container: Array<Array<Int>>): String {
    // Write your code here
    val capacities = mutableMapOf<Int, Int>()
    for (i in container.indices) {
        val cap = container[i].sum()
        capacities[cap] = (capacities[cap] ?: 0) + 1
    }

    val colorCounts = mutableMapOf<Int, Int>()
    for (i in container.indices) {
        var count = 0
        for (j in container.indices) {
            count += container[j][i]
        }
        colorCounts[count] = (colorCounts[count] ?: 0) + 1
    }

    if (capacities.size != colorCounts.size) {
        return "Impossible"
    }
    for ((cap, count) in capacities) {
        if (count != colorCounts[cap]) {
            return "Impossible"
        }
    }

    return "Possible"
}

fun main() {
    arrayOf(
            arrayOf(arrayOf(1,4), arrayOf(2,3)) to "Impossible",
            arrayOf(arrayOf(1,1), arrayOf(1,1)) to "Possible",
            arrayOf(arrayOf(0,2), arrayOf(1,1)) to "Impossible",
            arrayOf(arrayOf(1,3,1), arrayOf(2,1,2), arrayOf(3,3,3)) to "Impossible",
            arrayOf(arrayOf(0,2,1), arrayOf(1,1,1)  , arrayOf(2,0,0)) to "Possible",
    ).forEach { (container, output) ->
        assertEquals(output, organizingContainers(container))
    }
}
