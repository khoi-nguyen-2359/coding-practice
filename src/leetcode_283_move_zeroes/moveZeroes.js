/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    let j = 0 // zero
    let i = 0 // non-zero
    while (i < nums.length && j < nums.length) {
        if (nums[i] != 0 && nums[j] == 0 && i > j) {
            const tmp = nums[i]
            nums[i] = 0
            nums[j] = tmp
        }
        if (nums[i] == 0 || i < j) {
            ++i
        }
        if (nums[j] != 0) {
            ++j
        }
    }
    return nums
};

/*
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

i=0,z=0: 0 1 0 3 12
i=1,z=0: 0 1 0 3 12
i=2,z=1: 1 0 0 3 12
i=3,z=1: 1 0 0 3 12
i=4,z=2: 1 3 0 0 12
i=5,z=3: 1 3 12 0 0
*/

[
    [[0,1,0,3,12], [1,3,12,0,0]],
    [[0,0,0,3,12], [3,12,0,0,0]],
    [[0], [0]],
    [[1], [1]],
    [[1,0,2], [1,2,0]],
    [[1,2], [1,2]],
    [[0,0], [0,0]],
    [[0,0,1], [1,0,0]],
].forEach((value, index, array) =>  {
    const result = moveZeroes(value[0])
    console.log(result)
    console.assert(value[1].every((item, index) => result[index] == item))
})