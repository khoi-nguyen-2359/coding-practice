package leetcode_1071_greatest_common_divisor_of_strings

/**
 * m = len(str1)
 * n = len(str2)
 * => min(m,n) * (m + n)
 */
class SolutionBruteForce {
    fun gcdOfStrings(str1: String, str2: String): String {
        val (shorter, longer) = if (str1.length < str2.length) {
            str1 to str2
        }  else {
            str2 to str1
        }
        for (i in 1..shorter.length) {
            if (shorter.length % i == 0) {
                val sub = shorter.substring(0, shorter.length / i)
                if (isDivisor(sub, shorter) && isDivisor(sub, longer)) {
                    return sub
                }
            }
        }

        return ""
    }

    private fun isDivisor(sub: String, str: String): Boolean {
        if (str.length % sub.length != 0) {
            return false
        }

        for (i in str.indices) {
            if (sub[i % sub.length] != str[i]) {
                return false
            }
        }

        return true
    }
}

/*
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Input: str1 = "ABABABAB", str2 = "ABAB"
Output: "AB"
 */