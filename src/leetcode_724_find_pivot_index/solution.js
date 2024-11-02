/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function (nums) {
    var leftSum = 0
    var rightSum = nums.reduce((s, c, _) => s + c, 0)
    for (var i = 0; i < nums.length; ++i) {
        rightSum -= nums[i]
        if (leftSum == rightSum) {
            return i
        }
        leftSum += nums[i]
    }

    return -1
};

[
    { input: [1, 7, 3, 6, 5, 6], output: 3 },
    { input: [1, 2, 3], output: -1 },
    { input: [2, 1, -1], output: 0 },
    { input: [1, 0], output: 0 },
    { input: [0, -1], output: 1 },
].forEach(testcase => {
    console.log(pivotIndex(testcase.input), testcase.output)
})