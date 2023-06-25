package sort

/**
 * https://leetcode.com/problems/two-sum/
 */
object TwoSum {

    /**
     * sort + two pointers approach
     *
     * Another possible approach is map[target - x]
     */
    fun twoSum(nums: IntArray, t: Int): IntArray {
        val idxMap: MutableMap<Int, Int> = mutableMapOf()
        val dups: MutableMap<Int, Int> = mutableMapOf()
        nums.forEachIndexed { index, i ->
            if (idxMap.contains(i)) {
                dups[i] = index
            } else {
                idxMap[i] = index
            }
        }

        nums.sort()

        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val f = nums[l] + nums[r]
            if (f > t) {
                r--
            } else if (f < t) {
                l++
            } else {
                val left = idxMap[nums[l]]!!
                var right = idxMap[nums[r]]!!
                if (left == right) {
                    right = dups[nums[r]]!!
                }
                return intArrayOf(left, right)
            }
        }
        return intArrayOf(l, r)
    }

    @JvmStatic
    fun main() {
        twoSum(intArrayOf(-23, -11, -5, 0, 0, 1, 1, 2, 4, 7, 8, 25, 30), 7)
    }
}