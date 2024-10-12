/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
    let iS = 0
    let iT = 0
    while (iS < s.length && iT < t.length) {
        if (s[iS] == t[iT]) {
            ++iS
            ++iT
        } else {
            ++iT
        }
    }

    return iS == s.length
};

const posMap = new Map()
var buildPosMap = function(t) {
    for (let i = 0; i < t.length; ++i) {
        if (posMap[t[i]] === undefined) {
            posMap[t[i]] = []
        }
        posMap[t[i]].push(i)
    }
    return posMap
}

/**
 * One t for many s strings.
 * @param {*} s 
 * @param {*} t 
 * @returns 
 */
var isSubsequence2 = function(s, t) {
    if (posMap.size == 0) {
        buildPosMap(t)
    }
    let lastPos = -1
    for (let i = 0; i < s.length; ++i) {
        let posArray = posMap[s[i]]
        if (posArray === undefined) {
            return false
        }
        lastPos = posArray.find((value, index, obj) => value > lastPos)
        if (lastPos === undefined) {
            return false
        }
    }

    return true
};

[
    ["abc", "ahbgdc", true],
    ["axc", "ahbgdc", false],
    ["abc", "bacbac", true],
    ["abc", "bac", true],
    ["axc", "ah", false],
    ["axc", "", false],
    ["", "ahbgdc", false],
    ["b", "c", false],
].forEach((value, index, array) => {
    let result = isSubsequence2(value[0], value[1])
    console.log(result)
    console.assert(value[2] == result)
})