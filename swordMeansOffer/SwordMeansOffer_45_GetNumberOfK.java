/**
 * @author wb
 * @date 2020/2/21 - 20:40
 * 剑指 Offer---数字在排序数组中出现的次数
 */
public class SwordMeansOffer_45_GetNumberOfK {

    public int GetNumberOfK(int [] array , int k) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                index = i;
                break;
            }
        }
        if (index < 0) {
            return 0;
        }
        int count = 0;
        while (index < array.length) {
            if (array[index] == k) {
                count++;
                index++;
            } else {
                break;
            }
        }
        return count;
    }
}
