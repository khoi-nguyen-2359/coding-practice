package leetcode_639_Decode_Ways_II

class Solution {
    private val M = 1000000007
    fun numDecodings(s: String): Int {
        var ans = 0L
        var t1 = 1L
        var t2 = 0L
        for (i in s.length - 1 downTo 0) {
            ans = 0
            if (s[i] != '0') {
                ans = (t1 * if (s[i] == '*') {
                    9
                } else {
                    1
                }) % M
                if (i + 1 < s.length) {
                    when {
                        s[i] != '*' && s[i + 1] != '*' -> {
                            if ((s[i] - '0') * 10 + (s[i + 1] - '0') in 1..26) {
                                ans = (ans + t2) % M
                            }
                        }
                        s[i] == '*' && s[i+1] == '*' -> {
                            ans = (ans + t2 * 15) % M  // 11 .. 19 + 21..26
                        }
                        s[i] == '*' -> {
                            // *s[i+1]
                            ans = (ans + t2 * if (s[i + 1] in '0'..'6') {
                                2
                            } else {
                                1
                            }) % M
                        }
                        s[i+1] == '*' -> {
                            // s[i]*
                            ans = (ans + t2 * when (s[i]) {
                                '1' -> 9
                                '2' -> 6
                                else -> 0
                            }) % M
                        }
                    }
                }
            }

            t2 = t1
            t1 = ans
        }
        return ans.toInt()
    }
}

fun main() {
    arrayOf(
            "*",
            "*0",
            "*9",
            "1*",
            "3*",
            "**",
            "1*1",
            "*********",
            "7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*",
    ).forEach {
        Solution().numDecodings(it).let(::println)
    }
}

/*
11121

if s[i] valid -> dp[i] += dp[i+1] or 1
if s[i]s[i+1] valid -> dp[i] += dp[i+2] or 1
 */