package hackerrank_Dynamic_Array

import TestCases
import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'dynamicArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun dynamicArray(n: Int, queries: Array<Array<Int>>): Array<Int> {
    var lastAnswer = 0
    val arr = mutableMapOf<Int, MutableList<Int>>()
    val answers = mutableListOf<Int>()
    for (q in queries) {
        val idx = ((q[1] xor lastAnswer) % n)
        if (q[0] == 1) {
            if (arr[idx] == null) {
                arr[idx] = mutableListOf()
            }
            arr[idx]?.add(q[2])
        } else {
            lastAnswer = arr[idx]?.get(q[2] % (arr[idx]?.size ?: 0)) ?: 0
            answers.add(lastAnswer)
        }
    }
    return answers.toTypedArray()
}

fun main(args: Array<String>) {
    dynamicArray(2, arrayOf(
        arrayOf(1,0,5),
        arrayOf(1,1,7),
        arrayOf(1,0,3),
        arrayOf(2,1,0),
        arrayOf(2,1,1),
    ))
}
