import kotlin.test.assertEquals

/*
 * Complete the 'divisibleSumPairs' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER k
 *  3. INTEGER_ARRAY ar
 */

/*
STDIN           Function
-----           --------
6 3             n = 6, k = 3
1 3 2 6 1 2     ar = [1, 3, 2, 6, 1, 2]

ar[i] == x
=> find y : (x+y) % k == 0 => x + y = t * k
x == 2
y == ... -5, 1, 4, ...
 */

fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
    var count = 0
    for (i in 0 .. n - 2) {
        for (j in i + 1 until n) {
            if ((ar[i] + ar[j]) % k == 0) {
                ++count
            }
        }
    }

    return count
}

fun main(args: Array<String>) {
    arrayOf(
        (arrayOf(1,3,2,6,1,2) to 3) to 5,
        (arrayOf(-1,-3,2,6,1,2) to 3) to 4,
        (arrayOf(-5,3,2,0,1,4) to 3) to 4,
    ).forEach { (input, exp) ->
        assertEquals(exp, divisibleSumPairs(input.first.size, input.second, input.first))
    }
}
