package leetcode_1017_Convert_to_Base_neg2

class Solution {
    fun baseNeg2(n: Int): String = buildString {
        if (n == 0) {
            append(0)
        } else {
            var c = n
            while (c != 0) {
                var d = c % -2
                c /= -2
                if (d < 0) {
                    d += 2
                    c += 1
                }
                append(d)
            }
            reverse()
        }
    }
}