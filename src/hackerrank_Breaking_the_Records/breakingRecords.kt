package hackerrank_Breaking_the_Records

/*
 * Complete the 'breakingRecords' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY scores as parameter.
 */

fun breakingRecords(scores: Array<Int>): Array<Int> {
    var low = scores[0]
    var high = scores[0]
    var breakLow = 0
    var breakHigh = 0

    for (i in scores.indices) {
        if (scores[i] < low) {
            low = scores[i]
            ++breakLow
        }

        if (scores[i] > high) {
            high = scores[i]
            ++breakHigh
        }
    }

    return arrayOf(breakHigh, breakLow)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val scores = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = breakingRecords(scores)

    println(result.joinToString(" "))
}
