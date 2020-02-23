/**
 * @author wb
 * @date 2020/2/22 - 14:04
 * 剑指 Offer---圆圈中最后剩下的数
 */
public class SwordMeansOffer_54_LastRemaining_Solution {

    /**
     * 解题思路：
     *  该题本质上是约瑟夫环问题（即给定人数、起点、方向和要跳过的数字，选择圆圈中位置以达到木匾），
     *  利用约瑟夫问题的递推公式求解
     *  f(n, k) = （f(n - 1, k) + k） % n;
     *
     * */
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0) {
            return -1;
        }
        // 递归出口
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
}
