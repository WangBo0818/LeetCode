/**
 * @author wb
 * @date 2019/12/25 - 22:28
 * 剑指offer---10.1 斐波那契数列
 */
public class SwordMeansOffer_10_1_Fibonacci {
    /**
     * 解法一：使用递归直接求解
     * */
    public int Fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 解法二：动态规划
     * 解法一使用递归求解，会重复计算一些子问题。例如，f(4)会计算f(3)和f(2)，而f(3)会计算f(2)和f(1),
     * 这样f(2)就被重复计算了一次
     *
     * 递归是将原问题分解为多个子问题求解，动态规划也是，但是动态规划会将子问题的解存起来，
     * 这样就避免了重复计算。通过牛客网给出的执行时间，解法二的执行时间要远远少于解法一的执行时间
     * */
    public int Fibonacci2(int n) {
        if(n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 2; i <= n; i++) {
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[n];
    }

    /**
     * 解法三：
     * 解法二在时间复杂度方面已经很接近完美了，但是空间复杂度是O(n)
     * 第i 项的结果只依赖第i-1 项和第i-2 项，因此只要知道了斐波那契数列的前两项，
     * 便可求解出第i 项，这样就不同额外定义数组，空间复杂度降为O(1)
     *
     * */
    public int Fibonacci3(int n) {
        if(n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        int result = 0;
        for(int i = 2; i <= n; i++) {
            result += first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
