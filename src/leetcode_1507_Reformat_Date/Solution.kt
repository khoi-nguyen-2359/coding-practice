package leetcode_1507_Reformat_Date

class Solution {
    fun reformatDate(date: String): String {
        val parts = date.split(' ')
        val day = buildString {
            parts[0].forEach {
                if (it.isLetter()) {
                    if (length == 1) {
                        insert(0, '0')
                    }
                    return@forEach
                }
                append(it)
            }
        }
        val month = when (parts[1]) {
            "Jan" -> "01"
            "Feb" -> "02"
            "Mar" -> "03"
            "Apr" -> "04"
            "May" -> "05"
            "Jun" -> "06"
            "Jul" -> "07"
            "Aug" -> "08"
            "Sep" -> "09"
            "Oct" -> "10"
            "Nov" -> "11"
            else -> "12"
        }
        return "${parts[2]}-$month-$day"
    }
}

fun main() {
    arrayOf(
            "20th Oct 2052",
            "6th Jun 1933",
            "26th May 1960",
    ).forEach {
        Solution().reformatDate(it).let(::println)
    }
}

/*
Input: date = "20th Oct 2052"
Output: "2052-10-20"

days = {
    1st -> 1
    ...
    31st -> 31
}

months = {
    Jan -> 01
    ...
    Dec -> 12
}


 */