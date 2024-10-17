/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[][]}
 */
var findDifference = function (nums1, nums2) {
    let set1 = new Set(nums1)
    let set2 = new Set(nums2)
    nums1.forEach((n1, _, __) => set2.delete(n1))
    nums2.forEach((n2, _, __) => set1.delete(n2))

    return [[...set1], [...set2]]
};

[
    { nums: [[2, 4, 6], [1, 2, 3]], outp: [[4, 6][1, 3]] },
    { nums: [[1, 2, 3, 3], [1, 1, 2, 2]], outp: [[3], new Array()] },
].forEach((val, _, __) => {
    let res = findDifference(val.nums[0], val.nums[1])
    console.log(...res)
})