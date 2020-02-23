import java.util.ArrayList;

/**
 * @author wb
 * @date 2020/2/22 - 9:38
 * 剑指 Offer---49. 和为 S 的连续正数序列
 */
public class SwordMeansOffer_49_FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (left < right) {
            int tmpSum = 0;
            for (int i = left; i <= right; i++) {
                tmpSum += i;
            }
            if (tmpSum < sum) {
                right++;
            } else if (tmpSum > sum) {
                left++;
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    tmp.add(i);
                }
                res.add(tmp);
                left++;
                right++;
            }
        }
        return res;
    }
}
