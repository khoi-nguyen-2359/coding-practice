package misc_urlify

/*
URLify (Write a method to replace all spaces in a string with '%20').
You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.
(Note: if implementing in java, please use a character array so that you can perform this operation in place.)

Ex: "The First[9]Example[17]    ", length = 21, true length = 17
=> "The%20First%20Example"

=> "A B  "
=> "A%20B"

0. set marker index equal to true length
1. loop backward from true length point to string start
    -> if visit a space
        -> copy to fulfill the char array from the end to the beginning
            -> copy content: from space index to prev marker index, space is replaced with %20
        -> set marker index as the space index
 */

class Solution {
    fun urlify(chars: CharArray, trueLen: Int) {
        var spaceMarker = trueLen
        var copyMarker = chars.size
        for (i in trueLen - 1 downTo 0) {
            if (chars[i] == ' ') {
                // copy
                val copyLen = spaceMarker - i + 2
                val copyStart = copyMarker - copyLen

                for (j in copyLen - 1 downTo 3) {
                    chars[j + copyStart] = chars[j + i - 2]
                }
                chars[copyStart] = '%'
                chars[copyStart+1] = '2'
                chars[copyStart+2] = '0'

                // update the markers
                spaceMarker = i
                copyMarker = copyStart
            }
        }
    }
}

fun main() {
    arrayOf(
            "The First Example    ".toCharArray() to 17,
            "A B  ".toCharArray() to 3,
            "   ".toCharArray() to 1,
            " A  ".toCharArray() to 2,
    ).forEach { (chars, trueLen) ->
        Solution().urlify(chars, trueLen)
        TestCases.printlnArray(chars.toTypedArray(), "")
    }
}
