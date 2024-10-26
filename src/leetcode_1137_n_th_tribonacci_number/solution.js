/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function (n) {
    var seeds = [0, 1, 1]

    if (n < 3) return seeds[n]

    var ans = 0
    for (var i = 3; i <= n; ++i) {
        ans = seeds[2] + seeds[1] + seeds[0]
        seeds[0] = seeds[1]
        seeds[1] = seeds[2]
        seeds[2] = ans
    }
    return ans
};

[1, 2, 3, 4, 5, 6, 7, 8, 9].forEach(e => {
    console.log(e, tribonacci(e))
});