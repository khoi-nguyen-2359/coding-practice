object TestCases {
    val unsortedIntArrays
    get() = arrayOf(
            intArrayOf(3,50,12,15,40,36,5,50,10,48,48),
            intArrayOf(28,27,39,36,5,45,30,5,46,49,7,15,30,31),
            intArrayOf(49,35,35,44,26,8,22,26,27,34),
            intArrayOf()
    )

    fun swap(array: IntArray, i: Int, j: Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
    }

    fun printlnArray(array: IntArray) {
        array.forEach {
            print("$it ")
        }
        println()
    }
}