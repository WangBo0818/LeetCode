/**
 * @author wb
 * @date 2019/12/28 - 22:12
 * 剑指offer---10.2 矩形覆盖
 */
public class SwordMeansOffer_10_2_RectCover {
    public int RectCover(int target) {
        if(target <= 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
