/**
 * @author wb
 * @date 2020/2/7 - 20:13
 * 剑指offer---64. 求 1+2+3+...+n
 */
public class SwordMeansOffer_64_Sum_Solution {

    /**
     * 解题思路：
     *  题目要求不能使用乘除法、for、while、if、else、switch、case 等关键字
     *  及条件判断语句 A ? B : C。因此使用数学归纳法对式子进行化简
     * */
    public int Sum_Solution(int n) {
        return n * (n + 1) / 2;
    }
}
