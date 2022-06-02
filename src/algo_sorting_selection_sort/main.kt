package algo_sorting_selection_sort

fun main() {
    arrayOf(
            intArrayOf(3,50,12,15,40,36,5,50,10,48,48),
            intArrayOf(28,27,39,36,5,45,30,5,46,49,7,15,30,31),
            intArrayOf()
    ).forEach {
        selectionSort(it)
        it.forEach {
            print(it)
            print(" ")
        }
        println("--")
    }
}

fun selectionSort(arr: IntArray) {
    for (i in arr.indices) {
        var minIndex = i
        for (j in i + 1 until arr.size) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j
            }
        }
        if (i != minIndex) {
            val tmp = arr[i]
            arr[i] = arr[minIndex]
            arr[minIndex] = tmp
        }
    }
}
