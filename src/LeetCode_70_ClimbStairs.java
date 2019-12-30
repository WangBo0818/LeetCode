/**
 * @author wb
 * @date 2019/12/30 - 16:53
 * LeetCode---70. 爬楼梯
 */
public class LeetCode_70_ClimbStairs {

    /**
     * 很简单和基本的动态规划问题
     * */
    public int climbStairs(int n) {
        int[] dp = new int[n];
        if(n <= 2) {
            return n;
        }
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
