/**
 * @author wb
 * @date 2020/2/6 - 20:17
 * LeetCode---121. 买卖股票的最佳时机
 */
public class LeetCode_121_MaxProfit {

    /**
     * 解题思路：将数组以折线图的形式表达，maxProfit 就是波峰和波谷的差值
     * */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
