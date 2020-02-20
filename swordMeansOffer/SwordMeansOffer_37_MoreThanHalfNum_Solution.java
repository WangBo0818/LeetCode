import java.util.Arrays;

/**
 * @author wb
 * @date 2020/2/19 - 23:20
 * 剑指 Offer---37. 数组中出现次数超过一半的数字
 */
public class SwordMeansOffer_37_MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        Arrays.sort(array);
        int count = 1;
        int i = 1;
        while (i < array.length) {
            if (count >= array.length / 2 + 1) {
                return array[i - 1];
            }
            if (array[i] == array[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            i++;
        }
        return 0;
    }
}
