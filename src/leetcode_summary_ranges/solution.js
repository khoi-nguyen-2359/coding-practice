/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function (nums) {
    var start = 0
    var result = []
    for (var i = 0; i < nums.length; ++i) {
        if (i == nums.length - 1 || nums[i] + 1 < nums[i + 1]) {
            if (i == start) {
                // single
                result.push(nums[i].toString())
            } else {
                // range
                result.push(`${nums[start]}->${nums[i]}`)
            }
            start = i + 1
        }
    }

    return result
};

require('../TestLoop').testLoop([
    { nums: [0, 1, 2, 4, 5, 7], expect: ["0->2", "4->5", "7"] },
    { nums: [0, 2, 3, 4, 6, 8, 9], expect: ["0", "2->4", "6", "8->9"] },
], summaryRanges)