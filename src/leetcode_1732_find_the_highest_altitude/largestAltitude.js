/**
 * @param {number[]} gain
 * @return {number}
 */
var largestAltitude = function(gain) {
    let altitude = 0
    let max = 0
    for (let i = 0; i < gain.length; ++i) {
        altitude += gain[i]
        max = Math.max(max, altitude)
    }

    return max
};

[
    { inp: [-5,1,5,0,-7], outp: 1 },
    { inp: [-4,-3,-2,-1,4,3,2], outp: 0 }
].forEach((val, idx, arr) => {
    let res = largestAltitude(val.inp)
    console.log(res, res == val.outp)
})

/**
    Input: gain = [-5,1,5,0,-7]
    Output: 1

    altitudes:
    0: 0
    1: -5
    2: -4
    3: 1
    4: 1
    5: -6
     */