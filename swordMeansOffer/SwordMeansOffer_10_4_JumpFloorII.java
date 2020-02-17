/**
 * @author wb
 * @date 2019/12/26 - 22:07
 * 剑指offer---10.4 变态跳台阶
 */
public class SwordMeansOffer_10_4_JumpFloorII {
    // 简单的动态规划
    public int JumpFloorII(int target) {
        if(target <= 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= target; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] += dp[j];
            }
            dp[i] += 1;
        }
        return dp[target];
    }
}
