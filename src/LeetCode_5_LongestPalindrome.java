/**
 * @author wb
 * @date 2019/12/26 - 9:45
 * LeetCode---5. 最长回文子串
 */
public class LeetCode_5_LongestPalindrome {
    /**
     * 解法一：暴力破解法，找出字符串的所有子串，判断子串是否为回文子串，返回最大长度的回文子串
     * */

    /**
     * 解法二：动态规划（推荐，但是从LeetCode上的提交情况来看，效果依然不好）
     *  本题动态规划的边界值为dp[0][1]=true，因为单个字符肯定是回文串
     *  若dp[left,right]为true，则dp[left+1,right-1]也为true（这里的dp[left+1,right-1]至少有两个元素才会有判断的必要），
     *  因为dp[left+1,right-1]只有一个元素或为null值，则一定是回文串；
     *  至少有两个元素等价于：left+1 < right-1 即right - left > 2
     *
     *  因此状态转移方程是：如果头尾字符相等，并且中间也为回文串
     * */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1) {
            return s;
        }
        int maxLen = 1;
        String maxLenStr = s.substring(0, 1);
        Boolean[][] dp = new Boolean[len][len];
        for(int right = 1; right < len; right++) {
            for(int left = 0; left < right; left++) {
                if(s.charAt(left) == s.charAt(right) && (right - left <= 2 || (dp[left + 1][right - 1] != null && dp[left + 1][right - 1]) )) {
                    dp[left][right] = true;
                    if(right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                        maxLenStr = s.substring(left, right + 1);
                    }
                }
            }
        }
        return maxLenStr;
    }
}
