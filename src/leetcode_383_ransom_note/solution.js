/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function (ransomNote, magazine) {
    // time complexity with this?
    if (magazine.length < ransomNote.length) {
        return false
    }

    var dict = new Map()    // space complexity?
    for (var c of magazine) {
        var count = dict.get(c)
        count = (count ? count : 0) + 1
        dict.set(c, count)
    }
    for (var c of ransomNote) {
        var count = dict.get(c)
        count = (count ? count : 0) - 1
        if (count < 0) {
            return false
        }
        dict.set(c, count)
    }

    return true
};

[
    { ransom: 'a', mgz: 'b', output: false },
    { ransom: 'aa', mgz: 'ab', output: false },
    { ransom: 'aa', mgz: 'aab', output: true },
].forEach(tc => {
    var res = canConstruct(tc.ransom, tc.mgz)
    console.log(res, tc.output)
})