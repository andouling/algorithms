package hashmap

import kotlin.math.max

object LongestConsecutive2Map {
    fun longestConsecutive(nums: IntArray): Int {
        val endsWith = hashMapOf<Int, Int>()
        val startsWith = hashMapOf<Int, Int>()
        var ans = 0
        for (num in nums.toHashSet()) {
            val start = endsWith[num - 1] ?: num
            val end = startsWith[num + 1] ?: num
            startsWith[start] = end
            endsWith[end] = start
            ans = max(ans, end - start + 1)
        }
        return ans
    }
}