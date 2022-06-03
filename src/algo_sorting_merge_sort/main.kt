package algo_sorting_merge_sort

import TestCases

fun main() {
    TestCases.unsortedIntArrays.forEach {
        mergeSort(it, 0, it.size - 1)
        it.forEach {
            print("$it ")
        }
        println()
    }
}

fun mergeSort(arr: IntArray, l: Int, r: Int) {
    if (l >= r) {
        return
    }
    val m = (l + r) / 2
    mergeSort(arr, l, m)
    mergeSort(arr, m + 1, r)
    merge(arr, l, m, r)
}

fun merge(arr: IntArray, l: Int, m: Int, r: Int) {
//    println("$l $m $r")
    var i = l
    var j = m + 1
    var k = 0
    val len = r - l + 1
    val sorted = IntArray(len)
    while (k <= len - 1) {
        val next = if ((i <= m && j <= r && arr[i] <= arr[j]) || j > r) {
            arr[i++]
        } else if ((i <= m && arr[j] <= arr[i]) || i > m) {
            arr[j++]
        } else {
            break
        }
        sorted[k++] = next
    }
    for (x in 0 until k) {
        arr[x + l] = sorted[x]
//        println("${x+l} ${sorted[x]}")
    }
}
