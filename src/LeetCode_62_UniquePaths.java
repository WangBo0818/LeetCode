/**
 * @author wb
 * @date 2020/2/10 - 21:10
 * LeetCode---62. 不同路径
 */
public class LeetCode_62_UniquePaths {

    /**
     * 解题思路：
     *  动态规划，和杨辉三角有些类似，要找到对应的关系
     * */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 初始化第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
