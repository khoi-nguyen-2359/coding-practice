package leetcode_121_best_time_to_buy_and_sell_stock

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        for (i in prices.indices) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]
            } else if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice
            }
        }

        return maxProfit
    }
}