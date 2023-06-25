import java.util.*

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * https://leetcode.com/problems/top-k-frequent-elements/submissions/969677477/
 */
object TopKElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val map = mutableMapOf<Int, Int>()
        val ans = IntArray(k)
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val minHeap = PriorityQueue<Pair<Int, Int>>() { a, b -> a.first - b.first }

        for ((num, fre) in map) {

            minHeap.offer(Pair(fre, num))

            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        var count = 0
        while (!minHeap.isEmpty()) {
            ans[count] = minHeap.peek().second
            count++
            minHeap.poll()
        }

        return ans
    }
}