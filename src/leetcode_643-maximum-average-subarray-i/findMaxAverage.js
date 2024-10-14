/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    let currSum = nums.slice(0, k)
        .reduce((sum, curr, idx, arr) => sum + curr)
    let maxAvg = currSum / k
    for (let i = 1; i <= nums.length - k; ++i) {
        currSum = currSum - nums[i-1] + nums[i+k-1]
        let avg = currSum / k
        if (avg > maxAvg) {
            maxAvg = avg
        }
    }

    return maxAvg
};

[
    { nums: [1,12,-5,-6,50,3], k: 4, outp: 12.75 },
    { nums: [1,12,-5,-6,50,3], k: 6, outp: 9.1666666667 },
    { nums: [5], k: 1, outp: 5 },
    { nums: [-1], k: 1, outp: -1 },
].forEach((val, idx, arr) => {
    let result = findMaxAverage(val.nums, val.k)
    console.log(result, val.outp)
})
