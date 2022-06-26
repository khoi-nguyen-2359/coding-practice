package hackerrank_Subarray_Division

/*
 * Complete the 'birthday' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY s
 *  2. INTEGER d
 *  3. INTEGER m
 */

fun birthday(s: Array<Int>, d: Int, m: Int): Int {
    if (s.size < m) {
        return 0
    }
    var sum = 0
    for (i in 0 .. m - 1) {
        sum += s[i]
    }
    var ans = if (sum == d) {
        1
    } else {
        0
    }
    for (i in 1 .. s.size - m) {
        sum = sum - s[i - 1] + s[i + m - 1]
        if (sum == d) {
            ++ans
        }
    }
    
    return ans
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val s = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val d = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val result = birthday(s, d, m)

    println(result)
}
