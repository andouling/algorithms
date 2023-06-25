package hashmap

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
object TopKElements {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // sorting an array by count would be N * Log(N) TreeSet
        // count occurences by char and store counts separately

        // another approach is to use PriorityHeap

        //map for digits to store count + linked list to storing counts order
        //like this we have:

        val map: MutableMap<Int, Int> = mutableMapOf()

        nums.forEach {
            val old = map[it]
            map[it] = (old ?: 0) + 1
        }

        val sortedList = map.entries.sortedByDescending {
            it.value
        }
        return IntArray(k) { sortedList[it].key }
    }
}