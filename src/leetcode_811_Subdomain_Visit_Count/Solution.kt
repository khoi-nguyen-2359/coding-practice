package leetcode_811_Subdomain_Visit_Count

class Solution {
    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val repCounters = mutableMapOf<String, Int>()
        for (cpd in cpdomains) {
            val rep: Int
            val domain: String
            cpd.split(" ").also {
                rep = it[0].toInt()
                domain = it[1]
            }
            var index = -1
            do {
                val subDomain = domain.substring(index + 1)
                repCounters[subDomain] = (repCounters[subDomain] ?: 0) + rep
                index = domain.indexOf('.', index + 1)
            } while (index != -1)
        }

        return repCounters.map {
            "${it.value} ${it.key}"
        }
    }
}

fun main() {
    Solution().subdomainVisits(arrayOf("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"))
            .forEach(::println)

}

/*
Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 */