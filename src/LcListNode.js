class LcListNode {constructor(val, next) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }

    logList() {
        if (this === LcListNode.EMPTY) {
            console.log("EMPTY LIST")
        } else {
            console.log(this.#logListInternal(this))
        }
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

    #logListInternal(node) {
        let log = node.val
        if (node.next) {
            log += ' -> ' + this.#logListInternal(node.next)
        }
        return log
    }

    static EMPTY = new LcListNode()

    static ListNode(val, next) {
        return LcListNode(val, next)
    }

    static fromArray(...nums) {
        if (nums.length == 0) {
            return LcListNode.EMPTY
        }
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