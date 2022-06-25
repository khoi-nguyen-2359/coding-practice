package leetcode_28_Implement_strStr

class SolutionRabinKarp {
    private val alphabet = 26.0
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.length < needle.length) {
            return -1
        }

        val needleHash = hash(needle, needle.length - 1)
        var rollingHash = hash(haystack, needle.length - 1)
        if (rollingHash == needleHash) {
            return 0
        }
        for (i in 1 .. haystack.length - needle.length) {
            rollingHash = (rollingHash - haystack[i-1].toInt() * Math.pow(alphabet, (needle.length - 1).toDouble())) * alphabet + haystack[i - 1 + needle.length].toInt()
            if (rollingHash == needleHash) {
                if (needle == haystack.substring(i, i + needle.length)) {
                    return i
                }
            }
        }

        return -1
    }

    private fun hash(str: String, end: Int): Double {
        var hash = 0.0
        for (i in 0..end) {
            hash += str[i].toInt() * Math.pow(alphabet, (end - i).toDouble())
        }
        return hash
    }
}

class SolutionKMP {
    fun strStr(haystack: String, needle: String): Int {
        val lps = lps(needle)
        var i = 0
        var j = 0
        while (i < haystack.length) {
            if (haystack[i] == needle[j]) {
                ++i
                ++j
                if (j == needle.length) {
                    return i - j
                }
            } else {
                if (j == 0) {
                    ++i
                } else {
                    j = lps[j - 1]
                }
            }
        }

        return -1
    }

    private fun lps(s: String): IntArray {
        val lps = IntArray(s.length)
        lps[0] = 0
        var i = 1
        var curr = 0
        while (i < s.length) {
            if (s[i] == s[curr]) {
                ++curr
            } else {
                curr = 0
            }
            lps[i] = curr
            ++i
        }
        return lps
    }
}

fun main() {
    arrayOf(
            "hello" to "he",
            "hello" to "ll",
            "aaaaa" to "bba",
            "abc" to "c",
            "aabaaabaaac" to "aabaaac",
            "aaaabaaabbabbaaaaaabbabbbaaabababaaaaabbbbbbbbbbbbbbbaabbbbabbaababbbababababaaaabbbbaaabababbbaaabbaabbabbbbbababbabbaabbbabaabaaaaabbbaaaaaabaaaabababababbaabaabbaaaaaaaababbabaa" to "aabbaaaabbbbaabaaabaabbaaababbabbbbbaba",
            "ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb" to "abbabbbabaa"
    ).forEach { (haystack, needle) ->
        SolutionKMP().strStr(haystack, needle).let(::println)
    }
}