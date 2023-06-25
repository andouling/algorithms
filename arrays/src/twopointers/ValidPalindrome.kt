package twopointers

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var p1: Int = 0
        var p2: Int = s.length - 1

        while (p1 < p2) {
            if (!isAlphanumeric(s[p1])) {
                p1++
                continue
            }
            if (!isAlphanumeric(s[p2])) {
                p2--
                continue
            }
            if (!s[p1].equals(s[p2], ignoreCase = true)) {
                return false
            } else {
                p1++
                p2--
            }
        }
        return true
    }

    fun isAlphanumeric(c: Char): Boolean {
        return c in 'A'..'Z' || c in 'a'..'z' || c in '0'..'9'
    }
}