package leetcode_1472_DesignBrowserHistory

class BrowserHistory(homepage: String) {
    private val history = mutableListOf(homepage)
    private var current = 0
    private var size = 1

    fun visit(url: String) {
        ++current
        if (current >= history.size) {
            history.add(url)
        } else {
            history[current] = url
        }
        size = current + 1
    }

    fun back(steps: Int): String {
        current = Math.max(0, current - steps)
        return history[current]
    }

    fun forward(steps: Int): String {
        current = Math.min(size - 1, current + steps)
        return history[current]
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */

fun main() {
    val browserHistory = BrowserHistory("leetcode.com")
    browserHistory.visit("google.com") // You are in "leetcode.com". Visit "google.com"

    browserHistory.visit("facebook.com") // You are in "google.com". Visit "facebook.com"

    browserHistory.visit("youtube.com") // You are in "facebook.com". Visit "youtube.com"

    browserHistory.back(1).also(::println) // You are in "youtube.com", move back to "facebook.com" return "facebook.com"

    browserHistory.back(1).also(::println) // You are in "facebook.com", move back to "google.com" return "google.com"

    browserHistory.forward(1).also(::println) // You are in "google.com", move forward to "facebook.com" return "facebook.com"

    browserHistory.visit("linkedin.com") // You are in "facebook.com". Visit "linkedin.com"

    browserHistory.forward(2).also(::println) // You are in "linkedin.com", you cannot move forward any steps.

    browserHistory.back(2).also(::println) // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"

    browserHistory.back(7).also(::println) // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
}