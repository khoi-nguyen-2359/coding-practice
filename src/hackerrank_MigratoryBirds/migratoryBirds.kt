package hackerrank_MigratoryBirds

/*
 * Complete the 'migratoryBirds' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun migratoryBirds(arr: Array<Int>): Int {
    val counters = mutableMapOf<Int, Int>()
    var maxCounter = 0
    for (i in arr) {
        val c = 1 + (counters[i] ?: 0)
        counters[i] = c
        if (c > maxCounter) {
            maxCounter = c
        }
    }
    var minId = Int.MAX_VALUE
    for (c in counters) {
        if (c.value == maxCounter && c.key < minId) {
            minId = c.key
        }
    }
    return minId
}

fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = migratoryBirds(arr)

    println(result)
}
