package leetcode_121_Best_Time_to_Buy_and_Sell_Stock_2

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minStock = Int.MAX_VALUE
        var maxProfit = 0
        for (i in prices.indices) {
            if (prices[i] < minStock) {
                minStock = prices[i]
            } else if (prices[i] - minStock > maxProfit) {
                maxProfit = prices[i] - minStock
            }
        }

        return maxProfit
    }
}

fun main() {
    arrayOf(
            intArrayOf(7,1,5,3,6,4),
            intArrayOf(7,6,4,3,1),
    ).forEach {
        Solution().maxProfit(it).let(::println)
    }
}