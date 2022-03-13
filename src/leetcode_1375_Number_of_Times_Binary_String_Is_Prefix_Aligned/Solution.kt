package leetcode_1375_Number_of_Times_Binary_String_Is_Prefix_Aligned

class Solution {
    fun numTimesAllBlue(flips: IntArray): Int {
        val binString = CharArray(flips.size) { '0' }
        val mask = CharArray(flips.size) { '0' }
        var count = 0
        for (i in flips.indices) {
            mask[i] = '1'
            binString[flips[i] - 1] = '1'
//            println(binString)
//            println(mask)
            for (j in 0..i) {
                if (mask[j] != binString[j]) {
                    break
                }
                if (j == i && mask[j] == binString[j]) {
                    ++count
                }
            }
        }

        return count
    }
}

fun main() {
    Solution().numTimesAllBlue(intArrayOf(4, 1, 2, 3)).let(::println)
}