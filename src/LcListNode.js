class LcListNode {
    constructor(val, next) {
        this.val = val
        this.next = next
    }

    logList() {
        console.log(this.toArray().join('->'))
    }

    toArray() {
        var curr = this
        var arr = []
        while (curr) {
            arr.push(curr.val)
            curr = curr.next
        }
        return arr
    }

    static ListNode(val, next) {
        return new LcListNode(val, next)
    }

    static fromArray(...nums) {
        var prev = new LcListNode(nums[0])
        var root = prev
        for (var i = 1; i < nums.length; ++i) {
            var curr = new LcListNode(nums[i])
            prev.next = curr
            prev = curr
        }
        return root
    }
}

exports.ListNode = LcListNode.ListNode
exports.LinkedList = LcListNode.fromArray