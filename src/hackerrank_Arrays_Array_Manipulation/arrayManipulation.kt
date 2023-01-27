package hackerrank_Arrays_Array_Manipulation

/*
 * Complete the 'arrayManipulation' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val values = Array(n + 1) { 0 }
    var max = 0L
    queries.forEach {
        values[it[0] - 1] += it[2]
        values[it[1]] -= it[2]
    }
    var runningSum = 0L
    values.forEach {
        runningSum += it
        if (runningSum > max) {
            max = runningSum
        }
    }
    return max
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}
