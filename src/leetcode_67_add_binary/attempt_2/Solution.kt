package leetcode_67_add_binary.attempt_2

import java.lang.StringBuilder

class Solution {
    fun addBinary(a: String, b: String): String {
        var ia = a.length - 1
        var ib = b.length - 1
        var c = 0
        val s = StringBuilder()
        while (ia >= 0 || ib >= 0) {
            val va = a.getOrElse(ia) { '0' }
            val vb = b.getOrElse(ib) { '0' }
            val vs = (va - '0') + (vb - '0') + c
            s.append(vs % 2)
            c = vs / 2
            --ia
            --ib
        }
        if (c == 1) {
            s.append(c)
        }

        return s.reverse().toString()
    }
}

fun main() {
    val res = Solution().addBinary("1010", "1011")
    println(res)
}