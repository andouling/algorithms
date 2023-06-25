package prefixsum

/**
 * The main idea is to store a value that's represent a result of a prefix product and suffix product.
 *
 * Thus, we're using prefix product & suffix product approach just in place (within res array) to achieve O(N)
 * complexity and O(1) memory.
 */
class ProductExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val res = IntArray(n)
        res[0] = 1
        //prefix pass
        for (i in 1 until n) {
            res[i] = res[i - 1] * nums[i - 1]
        }
        //suffix pass
        var suffix = 1
        for (i in n - 1 downTo 0) {
            res[i] *= suffix
            suffix *= nums[i]
        }
        return res
    }
}