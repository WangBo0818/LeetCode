import java.util.ArrayList;

/**
 * @author wb
 * @date 2020/2/22 - 10:01
 * 剑指 Offer---50. 和为 S 的两个数字
 */
public class SwordMeansOffer_50_FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        boolean flag = false;
        while (left < right) {
            int tmpSum = array[left] + array[right];
            int tmp = array[left] * array[right];
            if (tmpSum < sum) {
                left++;
            } else if (tmpSum > sum) {
                right--;
            } else {
                if (tmp < min) {
                    min = tmp;
                    i = left;
                    j = right;
                }
                flag = true;
                left++;
                right--;
            }
        }
        if (flag) {
            res.add(array[i]);
            res.add(array[j]);
        }
        return res;
    }
}
