package algo_sorting_insertion_sort

import TestCases

fun main() {
    TestCases.unsortedIntArrays.forEach {
        insertionSort(it)
        it.forEach {
            print(it)
            print(" ")
        }
        println()
    }
}

fun insertionSort(arr: IntArray) {
    for (i in 1 until arr.size) {
        val pivot = arr[i]
        var j = i - 1
        while (j >= 0 && pivot < arr[j]) {
            arr[j + 1] = arr[j]
            --j
        }
        arr[j + 1] = pivot
    }
}
