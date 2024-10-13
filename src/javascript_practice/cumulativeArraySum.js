
const cumSum = data => data.reduce((accum, curr, idx, arr) => accum + curr, 0)

const array = [[1,3,2,4,0], [1,3,2,4,0,-1,-3,-2,-4], [3], []]
array.forEach(element => console.log(cumSum(element)))