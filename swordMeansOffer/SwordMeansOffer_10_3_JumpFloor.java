/**
 * @author wb
 * @date 2019/12/26 - 21:55
 * 剑指offer---10.3 跳台阶
 */
public class SwordMeansOffer_10_3_JumpFloor {
    // 简单的动态规划
    public int JumpFloor(int target) {
        if(target <= 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        // 动态规划的边界
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
