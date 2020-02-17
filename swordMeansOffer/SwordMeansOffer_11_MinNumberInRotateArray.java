/**
 * @author wb
 * @date 2019/12/28 - 22:24
 * 剑指offer---11. 旋转数组的最小数字
 */
public class SwordMeansOffer_11_MinNumberInRotateArray {
    /**
     * 解题思路很简单，遍历array 数组，只要数组的某个元素值（下标为i）小于其前一个元素值，
     * 则说明，原数组是从下标为i 的地方旋转的，对应的array[i] 就是原数组中的第一个元素，
     * 也为最小的元素
     * */
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        if(array.length == 1) {
            return array[0];
        }
        for(int i = 1; i < array.length; i++) {
            if(array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return 0;
    }
}
