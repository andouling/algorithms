object MinimumWindowSubstring {
    //ADOBECODEBANC -> ADOBEC, BECODEBA, CODEBA, BANC
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length) {
            return ""
        }
        var curr = SlidingWindow()
        var have: MutableMap<Char, Int> = HashMap()
        var need: MutableMap<Char, Int> = HashMap()
        var haveIndicator: Int = 0
        t.forEach { c ->
            val count: Int = need[c] ?: 0
            need[c] = count + 1
            have[c] = 0
        }
        var needIndicator: Int = need.size
        var minWindow: SlidingWindow? = null
        s.forEach {
            curr.expand()
            val haveCount = have[it] ?: -1
            //have(1) == need(3)
            if (haveCount != -1) {
                have[it] = haveCount + 1
                if (have[it] == need[it]) {
                    haveIndicator++
                }
            }
            //collapse
            //ADOBEC -> DOBEC
            while (haveIndicator == needIndicator) {
                //store result
                if (minWindow == null || curr < minWindow!!) {
                    minWindow = curr.copy()
                }
                val haveCount2 = have[s[curr.start]] ?: -1
                val needCount2 = need[s[curr.start]] ?: -1
                if (haveCount2 != -1) {
                    if (haveCount2 == needCount2) {
                        haveIndicator--
                    }
                    have[s[curr.start]] = haveCount2 - 1
                }
                curr.collapse()
            }
        }
        return if (minWindow == null) {
            ""
        } else {
            s.substring(minWindow!!.start, minWindow!!.end)
        }
    }

    data class SlidingWindow(var start: Int = 0, var end: Int = 0) {
        operator fun compareTo(otherWindow: SlidingWindow): Int {
            return (end - start) - (otherWindow.end - otherWindow.start)
        }

        fun collapse() {
            start++
        }

        fun expand() {
            end++
        }
    }
}