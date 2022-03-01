package leetcode_12_Integer_to_Roman

class Solution {
    private val symbolValueMap = mapOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
    )

    fun intToRoman(num: Int): String {
        var intValue = num
        var result = ""
        var k = 1000
        while (k > 0) {
            var convertValue = intValue - intValue % k
            intValue %= k
            k /= 10
            if (convertValue == 0) {
                continue
            }
            symbolValueMap.keys.forEach {
                val count = convertValue / it
                if (count != 0) {
                    result += symbolValueMap[it]?.repeat(count)
                    convertValue %= it
                    if (convertValue == 0) {
                        return@forEach
                    }
                }
            }
        }

        return result
    }
}

fun main() {
    Solution().intToRoman(1876).let(::println)
}

// Input: num = 1994
// Output: "MCMXCIV"

/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 */