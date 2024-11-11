/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function (nums, k) {
    var window = k + 1
    var exists = new Set() // space complexcity?
    for (var i = 0; i < nums.length; ++i) {
        if (i >= window) {
            exists.delete(nums[i - window])
        }
        if (exists.has(nums[i])) {
            return true
        }
        exists.add(nums[i])
    }

    return false
};

require('../TestLoop').testLoop([
    { nums: [1, 2, 3, 1], k: 3, expect: true },
    { nums: [1, 0, 1, 1], k: 1, expect: true },
    { nums: [1, 2, 3, 1, 2, 3], k: 2, expect: false },
    { nums: [1, 2, 3, 1, 2, 3], k: 0, expect: false },
    { nums: [1, 2, 1], k: 6, expect: true },
    { nums: [1], k: 2, expect: false },
    { nums: [1], k: 1, expect: false },
    { nums: [1], k: 0, expect: false },
], containsNearbyDuplicate)