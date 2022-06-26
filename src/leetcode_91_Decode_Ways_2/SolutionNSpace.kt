package leetcode_91_Decode_Ways_2

class SolutionNSpace {
    fun numDecodings(s: String): Int {
        val dp = IntArray(s.length + 1) { 0 }
        dp[dp.size - 1] = 1
        for (i in s.length - 1 downTo 0) {
            if (s[i] == '0') {
                continue
            }

            dp[i] += dp[i + 1]

            if (i + 1 < s.length && (s[i] - '0') * 10 + (s[i + 1] - '0') in 1..26) {
                dp[i] += dp[i + 2]
            }
        }
        return dp[0]
    }
}

class SolutionConstantSpace {
    fun numDecodings(s: String): Int {
        var ans = 0
        var t1 = 1
        var t2 = 0
        for (i in s.length - 1 downTo 0) {
            ans = 0
            if (s[i] != '0') {
                ans = t1
                if (i + 1 < s.length && (s[i] - '0') * 10 + (s[i + 1] - '0') in 1..26) {
                    ans += t2
                }
            }

            t2 = t1
            t1 = ans
        }
        return ans
    }
}

fun main() {
    arrayOf(
            "11106",
            "12",
            "226",
            "06",
            "0",
            "99",
            "9",
            "11121",
    ).forEach {
        SolutionConstantSpace().numDecodings(it).let(::println)
    }
}

/*
11121

if s[i] valid -> dp[i] += dp[i+1] or 1
if s[i]s[i+1] valid -> dp[i] += dp[i+2] or 1
 */