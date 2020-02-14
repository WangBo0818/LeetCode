/**
 * @author wb
 * @date 2020/2/14 - 22:43
 * LeetCode---202. 快乐数
 */
public class LeetCode_202_IsHappy {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);
        return fast == 1;
    }

    private int bitSquareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int bit = num % 10;
            sum += bit;
            num /= 10;
        }
        return sum;
    }
}
