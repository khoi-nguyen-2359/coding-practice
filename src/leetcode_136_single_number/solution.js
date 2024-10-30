/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    return nums.reduce((prev, curr, _) => prev ^ curr, 0)
};

[
    { inp: [2,2,1], outp: 1},
    { inp: [4,1,2,1,2], outp: 4},
    { inp: [1], outp: 1},
].forEach(testcase => {
    console.log(singleNumber(testcase.inp), testcase.outp)
})