/** 
 * Forward declaration of guess API.
 * @param {number} num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * var guess = function(num) {}
 */

/**
 * @param {number} n
 * @return {number}
 */
var guessNumber = function (n) {
    var lo = 1
    var hi = n
    while (true) {
        var mid = Math.floor((lo + hi) / 2)
        console.log(mid)
        switch (guess(mid)) {
            case -1:
                hi = mid - 1
                break;
            case 1:
                lo = mid + 1
                break;
            default: return mid
        }
    }
};

var picked
var guess = function (n) {
    if (n > picked) return -1
    if (n < picked) return 1
    return 0
};

[
    { n: 6, picked: 6, output: 6 },
    { n: 6, picked: 1, output: 1 },
    { n: 7, picked: 7, output: 7 },
    { n: 7, picked: 1, output: 1 },
    { n: 1, picked: 1, output: 1 },
    { n: 2, picked: 2, output: 2 },
].forEach(tc => {
    picked = tc.picked
    var res = guessNumber(tc.n)
    console.log(res, tc.output)
})