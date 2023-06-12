package hashmap

object ValidAnagram {

    fun isAnagram(s: String, t: String): Boolean {
        val map: MutableMap<Char, Int> = mutableMapOf()
        s.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        t.forEach {
            val count = map[it] ?: return false
            if (count == 0) {
                return false
            } else {
                if (count - 1 == 0) {
                    map.remove(it)
                } else {
                    map[it] = count - 1
                }
            }
        }
        return map.isEmpty()
    }

    @JvmStatic
    fun main() {

    }

}