/**
 * TODO consider Array(26)
 * https://leetcode.com/problems/permutation-in-string/
 */
object PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) {
            return false
        }
        val charsMap: MutableMap<Char, Int> = HashMap()
        s1.forEach {
            charsMap.put(it, (charsMap[it] ?: 0) + 1)
        }
        val usedChars: MutableMap<Char, Int> = HashMap(charsMap)
        var winLen: Int = 1
        var curr: Int = 0

        while (curr < s2.length) {
            val c = s2[curr]
            if (usedChars.contains(c)) {
                val count = usedChars[c] ?: 0
                if (count == 1) {
                    usedChars.remove(c)
                } else {
                    usedChars.put(c, count - 1)
                }
            } else {
                //collapse window
                while (!usedChars.contains(c) && winLen > 0) {
                    val char = s2[curr - (winLen - 1)]
                    val count = usedChars[char] ?: 0
                    usedChars.put(char, count + 1)
                    winLen--
                }
                continue
            }
            if (winLen == s1.length && usedChars.isEmpty()) {
                return true
            }
            curr++
            winLen++
        }
        return false
    }
}