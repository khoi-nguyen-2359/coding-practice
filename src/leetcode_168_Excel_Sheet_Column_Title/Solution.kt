package leetcode_168_Excel_Sheet_Column_Title

class Solution {
    fun convertToTitle(columnNumber: Int): String {
        var curr = columnNumber
        return buildString {
            while (curr != 0) {
                var converted = curr % 26
                if (converted == 0) {
                    converted = 26
                }
                insert(0, (converted + 64).toChar())
                curr -= converted
                curr /= 26
            }
        }
    }
}

fun main() {
    Solution().convertToTitle(701).let(::println)
}