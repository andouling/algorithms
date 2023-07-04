object LongestSubstringLength {
    fun lengthOfLongestSubstring(s: String): Int {
        // Set + SlidingWindow approach
        // 1) create set for chars occurencies
        // 2) foreach by dynamic sliding window, checking occurencies

        if (s.isEmpty()) {
            return 0
        }

        val charSet: MutableSet<Char> = HashSet()
        //window start index
        var start: Int = 0
        var length: Int = 0
        var maxLength: Int = 0
        s.forEachIndexed { i, c ->
            if (charSet.contains(c)) {
                if (maxLength < length) {
                    maxLength = length
                }
                while (charSet.contains(c)) {
                    //and collapse window from start by 1
                    length--
                    charSet.remove(s[start])
                    start++
                }
            }
            length++
            charSet += c
        }
        if (maxLength < length) {
            maxLength = length
        }

        return maxLength
    }
}