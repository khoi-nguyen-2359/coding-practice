package misc_1

import java.lang.StringBuilder

class Solution {
    private var split = -1
    private fun resolveRecursive(s: String, i: Int): String {
        val p = StringBuilder()
        var j = i
        while (j < s.length) {
            when {
                s[j].isDigit() -> {
                    val m = s[j] - '0'
                    println(m)
                    val res = resolveRecursive(s, j + 2)
                    println(res)
                    repeat(m) {
                        p.append(res)
                    }
                    j = split + 1
                }
                s[j].isLetter() -> {
                    p.append(s[j])
                    ++j
                }
                s[j] == ')' -> {
                    split = j
                    return p.toString()
                }
            }
        }

        return p.toString()
    }

    fun resolve(input: String): String {
        val result = StringBuilder()
        while (split < input.length - 1) {
            val output = resolveRecursive(input, 0)
            result.append(output)
        }

        return result.toString()
    }
}

fun main() {
    val input = "2(3(4(a)b)c)2(f)"
    val res = Solution().resolve(input)
    println(res)
}