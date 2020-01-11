import java.util.Stack;

/**
 * @author wb
 * @date 2020/1/11 - 13:30
 * LeetCode---32. 最长有效括号
 */
public class LeetCode_32_LongestValidParentheses {

    /**
     * 解法一：暴力破解
     *      使用栈来找出所有子串中的最长有效括号长度，这种解法会超时
     * */
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+2; j <= s.length(); j += 2) {
                // 判断该字串是否合理
                if(isValid(s.substring(i, j))) {
                    // 找出合理的最大长度的字串
                    maxlen = Math.max(maxlen, j-i);
                }
            }
        }
        return maxlen;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            }else if(c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 解法二：动态规划
     *      这种解题思路我是参照 LeetCode 的官方题解的，因此就不写自己解题思路了
     *      https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
     * */
    public int longestValidParentheses2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0 ;
        int[] dp = new int[s.length()];

        for(int i = 1; i < s.length(); i++) {
            // 所有以 '(' 结尾的字符串的有效括号长度都为 0
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    if(i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    }else {
                        dp[i] = 2;
                    }
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if(i - dp[i - 1] >= 2) {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    }else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
