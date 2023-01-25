package hackerrank_Array_Left_Rotation

/*
 * Complete the 'rotateLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER d
 *  2. INTEGER_ARRAY arr
 */

fun rotateLeft(d: Int, arr: Array<Int>): Array<Int> {
    val result = Array(arr.size) { 0 }
    for (i in arr.indices) {
        result[i] = arr[(i + d) % arr.size]
    }
    return result
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = rotateLeft(d, arr)

    println(result.joinToString(" "))
}
