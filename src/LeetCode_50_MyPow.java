/**
 * @author wb
 * @date 2020/1/18 - 20:33
 * LeetCode---50. Pow(x, n)
 */
public class LeetCode_50_MyPow {

    /**
     * 解法一：
     *  调用库函数，这种解法让我.....
     * */
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    /**
     * 解法二：
     *  暴力循环（超时）
     * */
    public double myPow2(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }
}
