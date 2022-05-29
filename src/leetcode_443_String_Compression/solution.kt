package leetcode_443_String_Compression

fun solution(inputString: CharArray): Int {
    var count = 1
    var i = 0
    var j = 0
    while (i < inputString.size) {
        if (i == inputString.size - 1 || inputString[i] != inputString[i+1]) {
            inputString[j++] = inputString[i]
            if (count > 1) {
                count.toString().forEach {
                    inputString[j++] = it
                }
                count = 1
            }
        } else {
            ++count
        }
        ++i
    }

    return j
}

class Solution {
    fun compress(chars: CharArray): Int {
        var count = 1
        var i = 0
        var j = 0
        while (i < chars.size) {
            if (i == chars.size - 1 || chars[i] != chars[i+1]) {
                chars[j++] = chars[i]
                if (count > 1) {
                    count.toString().forEach {
                        chars[j++] = it
                    }
                    count = 1
                }
            } else {
                ++count
            }
            ++i
        }

        return j
    }
}

fun main() {
    arrayOf(
         "abbaaaac",
         "",
         "aa",
    )
            .map { it.toCharArray() }
            .forEach {
                val len = Solution().compress(it)
                for (i in 0 until len) {
                    print(it[i])
                }
                println()
            }
}