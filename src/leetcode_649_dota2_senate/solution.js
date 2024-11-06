/**
 * @param {string} senate
 * @return {string}
 * 
 */
var predictPartyVictory = function (senate) {
    var senate1 = senate.split('')
    var senate2 = []
    var rights = [0, 0]
    var ids = {}
    if (senate1[0] == 'R') {
        ids = { 'R': 0, 'D': 1 }
    } else {
        ids = { 'R': 1, 'D': 0 }
    }

    var over = new Map([['R', 0], ['D', 0]])
    // console.log(over)
    do {
        var i = 0
        while (i < senate1.length) {
            var id = ids[senate1[i]]
            if (rights[1 - id] == 0) {
                if (senate2.length == 0 || senate2[0] == senate1[i]) {
                    ++rights[id]
                } else {
                    var removed = senate2.shift()
                    over.set(removed, over.get(removed) - 1)
                }
                senate2.push(senate1[i])
                over.set(senate1[i], over.get(senate1[i]) + 1)
            } else {
                --rights[1 - id]
            }
            ++i
            // console.log(i)
        }
        // console.log(over)
        // over = new Set(senate2.split(''))
        // console.log(senate2)
        senate1 = senate2
        senate2 = []
    } while (over.get('R') != 0 && over.get('D') != 0)
    // console.log(over)
    if (over.get('R') == 0) {
        return 'Dire'
    }
    return 'Radiant'
};

[
    { inp: "RD", outp: "Rariant" },
    { inp: "RDD", outp: "Dire" },
    { inp: "RRDDDDDRR", outp: "Dire" },
    { inp: "RRRDDD", outp: "Radiant" },
    { inp: "RRRDDDDR", outp: "Radiant" },
    { inp: "RRRDDDDRDDD", outp: "Dire" },
    { inp: "DRRDRDRDRDDRDRDR", outp: "Dire" },
].forEach(tc => {
    var res = predictPartyVictory(tc.inp)
    console.log(res, tc.outp)
})

// -