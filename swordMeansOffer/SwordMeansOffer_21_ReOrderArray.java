/**
 * @author wb
 * @date 2020/2/17 - 21:34
 * 剑指 Offer---21. 调整数组顺序使奇数位于偶数前面
 */
public class SwordMeansOffer_21_ReOrderArray {

    public void reOrderArray(int [] array) {
        int len = array.length;
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
