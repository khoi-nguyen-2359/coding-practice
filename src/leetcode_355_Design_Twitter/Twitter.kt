package leetcode_355_Design_Twitter

import java.util.PriorityQueue
import java.util.concurrent.atomic.AtomicLong

class Twitter() {
    private val followings = mutableMapOf<Int, MutableSet<Int>>()
    private val tweets = mutableMapOf<Int, MutableList<Tweet>>()

    fun postTweet(userId: Int, tweetId: Int) {
        val tweetList = tweets[userId] ?: mutableListOf()
        tweets[userId] = tweetList
        tweetList.add(Tweet(userId, tweetId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val queue = PriorityQueue<Pair<Tweet, Int>> { (t1, _), (t2, _) ->
            (t2.tweetCount - t1.tweetCount).toInt()
        }
        val feed = mutableListOf<Int>()
        val userSet = followings[userId] ?: mutableSetOf()
        userSet.add(userId)
        userSet.forEach { foloweeId ->
            val tweetList = tweets[foloweeId]
            tweetList?.lastOrNull()?.let { lastTw ->
                queue.add(lastTw to tweetList.size - 1)
            }
        }

        while (queue.isNotEmpty() && feed.size < 10) {
            val (tweet, index) = queue.poll()
            feed.add(tweet.tweetId)
            val nextTweet = tweets[tweet.userId]?.getOrNull(index - 1)
            if (nextTweet != null) {
                queue.add(nextTweet to index - 1)
            }
        }

        return feed
    }

    fun follow(followerId: Int, followeeId: Int) {
        val follows = followings[followerId] ?: mutableSetOf()
        followings[followerId] = follows
        follows.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followings[followerId]?.remove(followeeId)
    }

    data class Tweet(val userId: Int, val tweetId: Int) {
        val tweetCount = tweetCounter.incrementAndGet()

        companion object {
            private val tweetCounter = AtomicLong()
        }
    }
}

fun main() {
    val twitter = Twitter()
    twitter.postTweet(1, 5) // User 1 posts a new tweet (id = 5).

    twitter.getNewsFeed(1) // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]

    twitter.follow(1, 2) // User 1 follows user 2.

    twitter.postTweet(2, 6) // User 2 posts a new tweet (id = 6).

    var feed = twitter.getNewsFeed(1) // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    println(feed)
    twitter.unfollow(1, 2) // User 1 unfollows user 2.

    feed = twitter.getNewsFeed(1) // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    println(feed)
}