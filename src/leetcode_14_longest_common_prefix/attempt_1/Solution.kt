package leetcode_14_longest_common_prefix.attempt_1

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val result = StringBuilder()
        var curr: Int
        var i = 0
        while (strs.isNotEmpty()) {
            curr = strs[0].getOrNull(i)?.toInt()
                    ?: return result.toString()
            for (k in 1 until strs.size) {
                val si = strs[k].getOrNull(i)
                if (si == null || si.toInt() != curr) {
                    return result.toString()
                }
            }
            result.append(curr.toChar())
            ++i
        }
        return result.toString()
    }
}