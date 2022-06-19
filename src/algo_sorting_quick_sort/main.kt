package algo_sorting_quick_sort

import TestCases
import TestCases.printlnArray
import TestCases.swap

fun quickSort(array: IntArray, low: Int, high: Int) {
    if (low >= high) {
        return
    }
    val pivotIndex = partition(array, low, high)
    quickSort(array, low, pivotIndex - 1)
    quickSort(array, pivotIndex + 1, high)
}

fun partition(array: IntArray, low: Int, high: Int): Int {
    val pivotIndex = (low + high) / 2   // choose median pivot
    val pivot = array[pivotIndex]
//    println(pivot)
    var i = low - 1
    for (j in low .. high) {
        if (array[j] < pivot) {
            ++i
            if (i == pivotIndex) {
                ++i
            }
            swap(array, i, j)
//            printlnArray(array)
        }
    }
//    println(i)
    return if (pivotIndex > i) {
        swap(array, i + 1, pivotIndex)
        i + 1
    } else {
        swap(array, i, pivotIndex)
        i
    }
}

fun main() {
    TestCases.unsortedIntArrays.forEach {
        quickSort(it, 0, it.size - 1)
        printlnArray(it.toTypedArray())
    }
}