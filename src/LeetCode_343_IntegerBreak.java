/**
 * @author wb
 * @date 2020/2/17 - 20:56
 * LeetCode---343. 整数拆分
 */
public class LeetCode_343_IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }
}
