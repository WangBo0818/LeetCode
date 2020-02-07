/**
 * @author wb
 * @date 2020/2/7 - 19:21
 * LeetCode---96. 不同的二叉搜索树
 */
public class LeetCode_96_NumTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
