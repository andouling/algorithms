package hashmap

object LongestConsecutive {
    fun longestConsecutive(nums: IntArray): Int {
        //first let's eliminate duplicates
        val set: Set<Int> = nums.toSet()
        var longest: Int = 0

        set.forEach {
            if (!set.contains(it - 1)) {
                var length: Int = 0
                while (set.contains(it + length)) {
                    length++
                }
                longest = kotlin.math.max(longest, length)
            }
        }
        return longest
    }
}