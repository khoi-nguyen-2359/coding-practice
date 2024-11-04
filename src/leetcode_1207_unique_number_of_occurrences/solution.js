/**
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function (arr) {
    let counters = new Map()
    for (let i = 0; i < arr.length; ++i) {
        let counter = counters.get(arr[i]) ? counters.get(arr[i]) : 0
        counters.set(arr[i], counter + 1)
    }
    let exists = new Set(counters.values())
    return exists.size == counters.size
};

[
    { input: [1, 2, 2, 1, 1, 3], output: true },
    { input: [1, 2], output: false },
    { input: [-3, 0, 1, -3, 1, 1, 1, -3, 10, 0], output: true },
].forEach(tc => {
    let res = uniqueOccurrences(tc.input)
    console.log(res, tc.output)
})