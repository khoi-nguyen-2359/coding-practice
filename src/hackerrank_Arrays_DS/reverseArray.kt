package hackerrank_Arrays_DS

import kotlin.test.assertEquals

/*
 * Complete the 'reverseArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

fun reverseArray(a: Array<Int>): Array<Int> {
    var i = 0
    var j = a.size - 1
    while (i < j) {
        val tmp = a[i]
        a[i] = a[j]
        a[j] = tmp
        ++i
        --j
    }
    return a
}

fun main(args: Array<String>) {
    arrayOf(
        arrayOf(1,2,3) to arrayOf(3,2,1),
        arrayOf(1,2,3,4) to arrayOf(4,3,2,1),
        arrayOf(1) to arrayOf(1),
        arrayOf<Int>() to arrayOf(),
    ).forEach { (inp, exp) ->
        for (i in inp.indices) {
            assertEquals(exp[i], inp[inp.size - i - 1])
        }
    }
}
