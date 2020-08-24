package leetcode_937_reorder_data_in_log_files

class Solution {
    private fun isLetterLogOrDigitLog(log: String): Boolean {
        var spaceCount = 0
        log.forEach {
            if (it == ' ') {
                ++spaceCount
            }

            if (spaceCount >= 1) {
                if (it.isLetter()) {
                    return true
                } else if (it.isDigit()) {
                    return false
                }
            }
        }

        return false
    }

    fun reorderLogFiles(logs: Array<String>): Array<String> {
        logs.sortWith(Comparator { l1, l2 ->
            val isL1Letter: Boolean = isLetterLogOrDigitLog(l1)
            val isL2Letter: Boolean = isLetterLogOrDigitLog(l2)

            if (!isL1Letter && isL2Letter) {
                return@Comparator 1
            }

            if (isL1Letter && isL2Letter) {
                val l1FirstSpace = l1.indexOf(' ')
                val l2FirstSpace = l2.indexOf(' ')
                val compareLetters = l1.substring(l1FirstSpace).compareTo(l2.substring(l2FirstSpace))
                if (compareLetters != 0)
                    return@Comparator compareLetters

                return@Comparator l1.substring(0, l1FirstSpace).compareTo(l2.substring(0, l2FirstSpace))
            }

            if (!isL1Letter && !isL2Letter) {
                return@Comparator 0
            }

            // isL1Letter && !isL2Letter
            return@Comparator -1
        })

        return logs
    }
}

fun main(args: Array<String>) {
    val logs = arrayOf(
            "dig1 8 1 5 1",
            "let1 art can",
            "dig2 3 6",
            "let2 own kit dig",
            "let3 art zero"
    )

    Solution().reorderLogFiles(logs).forEach {
        println(it)
    }
}