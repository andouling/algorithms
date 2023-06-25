package sort

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
object TopKElements {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // sorting by count on each insertion would be N * Log(N) using TreeSet or else
        // count occurrences by char and store counts separately

        // another approach is to use PriorityHeap

        //map for digits to store count + linked list to storing counts order
        //like this we have:

        val map: MutableMap<Int, Int> = mutableMapOf()

        //O(N)
        nums.forEach {
            val old = map[it]
            map[it] = (old ?: 0) + 1
        }

        // O(Log(N))
        val sortedList = map.entries.sortedByDescending {
            it.value
        }
        // O(K) -> O(N) + O(Log(N)) + O(K) = O(N)
        return IntArray(k) { sortedList[it].key }
    }
}