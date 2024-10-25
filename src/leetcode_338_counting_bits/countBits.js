/**
 * @param {number} n
 * @return {number[]}
 * 101101 45
 * 101100 44
 * 101011
 */
var countBits = function (n) {
    return Array.from({ length: n + 1 }, (_, i) => {
        var curr = i
        var count = 0
        while (curr != 0) {
            if (curr & 1 == 1) {
                ++count
            }
            curr >>= 1
        }
        return count
    })
};

var countBitsDpLsbReversed = function (n) {
    var countBitsDpLsbSingle = function(n) {
        if (n == 0) {
            return 0
        }
        return (n & 0x1) + countBitsDpLsbSingle(n >> 1)
    }
    return Array.from({ length: n + 1}, (_, i) => {
        return countBitsDpLsbSingle(i)
    })
};

var countBitsDpLsb = function (n) {
    var ans = Array.from({ length: n + 1}, (_) => 0)
    for (var i = 0; i <= n; ++i) {
        ans[i] = ans[i >> 1] + (i & 0x1)
    }
    return ans
};

console.log(countBits(5))
console.log(countBitsDpLsb(5))
console.log(countBitsDpLsbReversed(5))
