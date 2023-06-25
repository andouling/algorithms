package hashmap

/**
 * https://leetcode.com/problems/group-anagrams/
 */
object GroupAnagramsSlow {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        //eat, tan, tea, nat, bat
        //[eat, tea] = [a, e, t]
        // approach 1: Set<String> chech occurences all of the chars in source scring to all of the chars in set's string
        // approach 2: Map<Hash, List<String>>

        val hashes: MutableMap<String, MutableList<String>> = mutableMapOf()
        strs.forEach { str ->
            val hashCode: String = hashCode(str)
            val listByHash: MutableList<String>? = hashes[hashCode]
            if (listByHash == null) {
                hashes[hashCode] = mutableListOf(str)
            } else {
                listByHash.add(str)
            }
        }
        return hashes.values.toList()
    }

    private fun hashCode(str: String): String {
        return str.toList().sorted().joinToString("")
    }
}