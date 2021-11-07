package leetcode_767_reorganize_string

class Solution {
    fun reorganizeString(s: String): String {
        val charCounters = Array('z' - 'a' + 1) { 0 }
        s.forEach { c ->
            val index = c - 'a'
            charCounters[index] = charCounters[index] + 100
        }

        charCounters.forEachIndexed { index, counter -> charCounters[index] += index }

        val sortedEntries = charCounters.sortedArray()

        val result = CharArray(s.length)
        var current = 1
        sortedEntries.forEachIndexed { index, value ->
            val char = (value % 100 + 'a'.code).toChar()
            val counter = value / 100
            if (counter > (s.length + 1) / 2) {
                return ""
            }
            for (i in 1..counter) {
                result[current] = char
                current += 2
                if (current >= s.length) {
                    current = 0
                }
            }
        }

        return String(result)
    }
}

fun main() {
    Solution().reorganizeString("tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao").also(::println)
//    Solution().reorganizeString("aab").also(::println)
}