/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    var memo = Array.from({length: cost.length}, _ => -1)
    var minCost = function(cost, i) {
        if (memo[i] != -1) {
            return memo[i]
        }
        switch (i) {
            case cost.length - 1:
            case cost.length - 2: memo[i] = cost[i]; break;
            default: memo[i] = cost[i] + Math.min(
                minCost(cost, i + 1),
                minCost(cost, i + 2),
            )
        }
        return memo[i]
    }
    return Math.min(
        minCost(cost, 0, cost.length),
        minCost(cost, 1, cost.length)
    )
};


