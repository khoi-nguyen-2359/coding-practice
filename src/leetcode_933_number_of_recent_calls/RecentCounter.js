
var RecentCounter = function () {
    this.requests = []
};

/** 
 * @param {number} t
 * @return {number}
 */
RecentCounter.prototype.ping = function (t) {
    this.requests.push(t)
    let last = this.requests.length - 1
    for (let i = this.requests.length - 2; i >= 0; --i) {
        if (this.requests[i] < t - 3000) {
            break
        }
        last = i
    }
    this.requests = this.requests.slice(last)
    return this.requests.length
};

/** 
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = new RecentCounter()
 * var param_1 = obj.ping(t)
 */

[
    { input: [1, 100, 3001, 3002], output: [1, 2, 3, 3] },
    { input: [1, 2, 3000, 3001, 6001], output: [1, 2, 3, 4, 2] },
    { input: [1, 2, 3000, 3001, 9000], output: [1, 2, 3, 4, 1] },
].forEach(element => {
    var counter = new RecentCounter()
    var counts = element.input.map(t => counter.ping(t))
    var res = counts.every((r, idx) => r == element.output[idx])
    console.log(counts, res)
});