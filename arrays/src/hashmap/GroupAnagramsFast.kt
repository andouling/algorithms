package hashmap

object GroupAnagramsFast {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        //eat, tan, tea, nat, bat
        //[eat, tea] = [a, e, t]
        // approach 1: Set<String> check occurrences for all the chars in source string to all the chars in set's string
        // approach 2: Map<Hash, List<String>>

        val map: MutableMap<String, MutableList<String>> = mutableMapOf()
        val charArray = CharArray('z' - 'a' + 1)
        strs.forEach { str ->
            charArray.fill('0')
            val hashString = hashString(charArray, str)
            val group = map.computeIfAbsent(hashString) { mutableListOf() }
            group.add(str)
        }
        return map.values.toList()
    }

    private fun hashString(charArray: CharArray, str: String): String {
        str.forEach {
            charArray[it - 'a']++
        }
        return String(charArray)
    }
}