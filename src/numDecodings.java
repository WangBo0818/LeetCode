/**
 * @author wb
 * @date 2019/12/15 - 12:50
 * leetcode91:解码方法
 */
public class numDecodings {
    public static void main(String[] args) {
        System.out.println(numDecodings2("22"));
    }

    private static int numDecodings(String s) {
        return getAns(s,0);
    }

    /**
     * 解法一：递归
     *      例如232232323232，对于第一个字符有两种划分方式
     *          2|32232323232 和 23|2232323232
     *      然后分别求出这两种划分方式的解法个数，最终结果为两种解法个数之和
     *
     * 但是这种解法的时间复杂度和空间复杂度都很差
     * */
    private static int getAns(String s, int start) {
        // 当start == s.length()，此时只有一种划分方法，返回1
        if(start == s.length()) {
            return 1;
        }
        if(s.charAt(start) == '0') {
            return 0;
        }
        // 第一种解码方法的解法
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;
        if(start < s.length() - 1) {
            int shiwei = (s.charAt(start) - '0') * 10;
            int gewei = s.charAt(start + 1) - '0';
            if(shiwei + gewei <= 26) {
                ans2 = getAns(s, start + 2);
            }
        }
        return (ans1 + ans2);
    }

    /**
     * 解法二：动态规划
     *      用一个dp 数组，dp[i]代表字符串s.substring(i, s.length()-1)即从i开始到结尾的
     *      字符串的解码方式
     *      递推式为：
     *          如果(s.charAt(i) - '0' + s.charAt(i+1) - '0') <= 26
     *          dp[i] = dp[i+1] + dp[i+2]
     * */

    public static int numDecodings2(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        // 将结束条件置为1
        dp[len] = 1;
        // 当最后一个数字不为0的时候，将其初始化为1
        if(s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        for(int i = len - 2; i >= 0; i--) {
             if(s.charAt(i) == '0') {
                 continue;
             }
             int ans1 = dp[i+1];
             int ans2 = 0;
             int shiwei = (s.charAt(i) - '0') * 10;
             int gewei = s.charAt(i + 1) - '0';
             if(shiwei + gewei <= 26) {
                 ans2 = dp[i+2];
             }
             dp[i] = ans1 + ans2;
        }
        return dp[0];
    }
}
