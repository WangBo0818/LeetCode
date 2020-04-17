/**
 * @author wb
 * @date 2020/4/15 - 9:38
 * LeetCode---338. 比特位计数
 */
public class LeetCode_338_CountBits {

    /**
     * 解题思路：
     *  1. 0 的 1 的个数为 0
     *  2. 当为奇数时，当前元素 1 的个数是前一个元素 1 的个数加上 1
     *  2. 当为偶数时，当前元素(i) 1 的个数与第 (i / 2) 个元素 1 的个数相等
     * */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
