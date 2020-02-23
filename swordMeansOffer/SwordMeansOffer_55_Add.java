/**
 * @author wb
 * @date 2020/2/22 - 14:28
 * 剑指 Offer---55. 不用加减乘除做加法
 */
public class SwordMeansOffer_55_Add {

    /**
     * 解题思路：
     *  位运算：a ^ b 是不考虑进位情况下的两数之和，而 (a & b) << 1 就是进位
     * */
    public int Add(int num1,int num2) {
        return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }
}
