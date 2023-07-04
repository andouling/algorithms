import java.util.Collections

object BestTimeToBuyAndSellStocks {
    fun maxProfit(prices: IntArray): Int {
        var buyIdx = -1
        var sellIdx = -1
        val variants: MutableList<Int> = mutableListOf()

        for (i in 1 until prices.size) {
            if (prices[i - 1] < prices[i]) {
                if (buyIdx == -1) {
                    buyIdx = i - 1
                } else if (prices[i - 1] < prices[buyIdx]) {
                    variants += prices[sellIdx] - prices[buyIdx]
                    buyIdx = i - 1
                    sellIdx = i
                    continue
                }
                if (sellIdx < 0 || prices[i] > prices[sellIdx]) {
                    sellIdx = i
                }
            }
        }
        if ((sellIdx < 0 || buyIdx < 0) && variants.isEmpty()) {
            return 0
        }
        return if (variants.isNotEmpty()) {
            kotlin.math.max(Collections.max(variants), kotlin.math.max(0, prices[sellIdx] - prices[buyIdx]))
        } else {
            kotlin.math.max(0, prices[sellIdx] - prices[buyIdx])
        }
    }
}