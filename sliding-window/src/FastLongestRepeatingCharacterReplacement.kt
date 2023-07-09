/**
 * https://www.youtube.com/watch?v=gqXU1UyA8pk
 */
object FastLongestRepeatingCharacterReplacement {

    fun characterReplacement(s: String, k: Int): Int {
        var left = 0
        var right = 0
        var maxCount = 0
        var maxLen = 0
        val frequency = IntArray(26)
        while (right < s.length) {
            val index = s[right] - 'A'
            frequency[index]++
            maxCount = Math.max(maxCount, frequency[index])
            //here is the trick (ここがポイントです)
            while (right - left + 1 - maxCount > k) {
                frequency[s[left] - 'A']--
                left++
            }
            maxLen = Math.max(maxLen, right - left + 1)
            right++
        }
        return maxLen
    }
}