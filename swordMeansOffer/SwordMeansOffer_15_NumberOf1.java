/**
 * @author wb
 * @date 2020/2/7 - 20:33
 * 剑指offer---15. 二进制中 1 的个数
 */
public class SwordMeansOffer_15_NumberOf1 {

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
