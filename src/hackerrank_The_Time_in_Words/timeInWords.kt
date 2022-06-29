package hackerrank_The_Time_in_Words

import kotlin.test.assertEquals

/*
 * Complete the 'timeInWords' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. INTEGER h
 *  2. INTEGER m
 */

fun timeInWords(h: Int, m: Int): String {
    val minuteTexts = mapOf(
            1 to "one",
            2 to "two",
            3 to "three",
            4 to "four",
            5 to "five",
            6 to "six",
            7 to "seven",
            8 to "eight",
            9 to "nine",
            10 to "ten",
            11 to "eleven",
            12 to "twelve",
            13 to "thirteen",
            14 to "fourteen",
            15 to "quarter",
            16 to "sixteen",
            17 to "seventeen",
            18 to "eighteen",
            19 to "nineteen",
            20 to "twenty",
            30 to "half"
    )

    val overMinuteText = "past"
    val underMinuteText = "to"

    val minute = if (m <= 30) {
        m
    } else {
        60 - m
    }

    return buildString {
        val minuteText = if (minute <= 20 || minute == 30) {
            minuteTexts[minute]
        } else {
            val minDigit2 = minute % 10
            "${minuteTexts[20]} ${minuteTexts[minDigit2]}"
        }
        addText(minuteText)

        val constMinuteText = when (m) {
            0, 15, 30, 45 -> null
            1 -> "minute"
            else -> "minutes"
        }
        addText(constMinuteText)

        var (overUnder, hourText) = if (m <= 30) {
            overMinuteText to minuteTexts[h]
        } else {
            underMinuteText to minuteTexts[h + 1]
        }

        overUnder = when (m) {
            0 -> ""
            else -> overUnder
        }
        addText(overUnder)

        addText(hourText)

        val hourConstText = if (m == 0) {
            "o' clock"
        } else {
            ""
        }
        addText(hourConstText)
    }.trim()
}

fun StringBuilder.addText(text: String?) {
    if (text != null) {
        append(text)
        append(" ")
    }
}

/*
5:10    -> ten      minutes     past            five
        -> minute   CONST       over/under      hour

5:40    -> quarter  to              six
        -> minute   over/under      hour
 */

fun main() {
    arrayOf(
            5 to 0 to "five o' clock",
            5 to 1 to "one minute past five",
            5 to 10 to "ten minutes past five",
            5 to 15 to "quarter past five",
            5 to 30 to "half past five",
            5 to 40 to "twenty minutes to six",
            5 to 45 to "quarter to six",
            5 to 47 to "thirteen minutes to six",
            5 to 28 to "twenty eight minutes past five",
    ).forEach { inp ->
        val (hours, exp) = inp
        val (h, m) = hours
        assertEquals(exp, timeInWords(h, m))
    }
}
