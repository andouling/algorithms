package hashmap

/**
 * Just storing count of particular int
 *
 * https://leetcode.com/problems/top-k-frequent-elements/submissions/969677477/
 *
 * See another approach here in the [heap] module.
 */
object TopKFrequent {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // sorting an array by count would be N * Log(N) TreeSet
        // count occurences by char and store counts separately

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
