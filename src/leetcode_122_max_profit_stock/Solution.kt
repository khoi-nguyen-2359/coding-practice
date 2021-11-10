package leetcode_122_max_profit_stock

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var p1 = -1
        var p2 = -1
        var profit = 0
        prices.forEach { p ->
            if (p1 == -1) {
                p1 = p
            } else if (p2 == -1) {
                p2 = p
            }

            if (p1 == -1 || p2 == -1) {
                return@forEach
            }

            if (p2 <= p1) {
                p1 = p2
                p2 = -1
            } else {
                if (p > p2) {
                    p2 = p
                } else if (p <= p2) {
                    profit += p2 - p1
//                    println("p1=$p1 p2=$p2 profit=$profit")
                    p1 = p2
                    p2 = -1
                }
            }
        }

        return profit
    }
}

fun main() {
    Solution().maxProfit(intArrayOf(7,6,3,2,1)).let(::println)
}