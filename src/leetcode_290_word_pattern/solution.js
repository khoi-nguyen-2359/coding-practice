/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
var wordPattern = function (pattern, s) {
    var words = s.split(' ')
    if (pattern.length != words.length) {
        return false
    }

    var l2w = new Map()
    var w2l = new Map()
    for (var i = 0; i < pattern.length; ++i) {
        if (!l2w.has(pattern[i])) {
            if (w2l.has(words[i])) {
                return false
            }
            l2w.set(pattern[i], words[i])
            w2l.set(words[i], pattern[i])
        } else {
            if (l2w.get(pattern[i]) != words[i]) {
                return false
            }
        }
    }

    return true
};

require('../TestLoop').testLoop([
    { pattern: "abba", s: "dog cat cat dog", expect: true },
    { pattern: "abba", s: "dog cat cat fish", expect: false },
    { pattern: "aaaa", s: "dog cat cat dog", expect: false },
    { pattern: "abba", s: "dog dog dog dog", expect: false },
], wordPattern)