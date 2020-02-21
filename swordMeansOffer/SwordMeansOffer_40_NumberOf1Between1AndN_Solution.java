/**
 * @author wb
 * @date 2020/2/20 - 19:30
 * 剑指 Offer---40. 从 1 到整数 n 中 1 出现的次数
 */
public class SwordMeansOffer_40_NumberOf1Between1AndN_Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String tmp = String.valueOf(i);
            for (int j = 0; j < tmp.length(); j++) {
                int temp = tmp.charAt(j) - '0';
                if (temp == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
