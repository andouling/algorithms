object SlowLongestRepeatingCharacterReplacement {
    fun characterReplacement(s: String, k: Int): Int {

        var length: Int = 0
        var currentChar: Char = s.first()
        var r: Int = k
        var i: Int = 0
        var maxLength: Int = 0
        var checkpoint: Int = 0
        while (i < s.length) {
            if (currentChar != s[i]) {
                if (r == 0) {
                    //brake the window
                    maxLength = kotlin.math.max(maxLength, length)
                    r = k
                    if (k > 0) {
                        i = checkpoint
                    }
                    currentChar = s[i]
                    length = 0
                    checkpoint = 0
                } else {
                    if (checkpoint == 0) {
                        //set once when missed
                        checkpoint = i
                    }
                    r--
                }
            }
            length++
            i++
        }
        if (length > 0) {
            val finalLength = kotlin.math.min(s.length, length + r)
            maxLength = kotlin.math.max(maxLength, finalLength)
        }
        return maxLength
    }
}