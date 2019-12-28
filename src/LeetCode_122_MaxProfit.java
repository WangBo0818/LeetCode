/**
 * @author wb
 * @date 2019/12/21 - 9:50
 * LeetCode122---买卖股票的最佳时机II
 */
public class LeetCode_122_MaxProfit {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {
                7, 1, 5, 3, 6, 4
        }));
    }

    /**
     * 算法思想很简单，因为不限制买卖的次数，所以只要后一天的股票价格比当前天高，就买进；
     * 比当前天第，则不买；这样稳赚不赔
     * */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if(tmp > 0) {
                profit +=  tmp;
            }
        }
        return profit;
    }
}
