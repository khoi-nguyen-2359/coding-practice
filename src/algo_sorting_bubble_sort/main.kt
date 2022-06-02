package algo_sorting_bubble_sort

import TestCases.unsortedIntArrays

fun main() {
    unsortedIntArrays.forEach {
        bubbleSort(it)
        it.forEach {
            print(it)
            print(" ")
        }
        println("--")
    }
}

fun bubbleSort(arr: IntArray) {
    for (i in 0..arr.size - 2) {
        for (j in i + 1 until arr.size) {
            if (arr[i] > arr[j]) {
                val tmp = arr[i]
                arr[i] = arr[j]
                arr[j] = tmp
            }
        }
    }
}

fun bubbleSortOptimized(arr: IntArray) {
    do {
        var swapped = false
        for (i in 0..arr.size - 2) {
            if (arr[i] > arr[i + 1]) {
                val tmp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = tmp
                swapped = true
            }
        }
    } while (swapped)
}