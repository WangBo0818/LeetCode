import java.util.Arrays;

/**
 * @author wb
 * @date 2019/12/21 - 9:08
 * 剑指offer编程题----3.数组中重复的数字
 */
public class SwordMeansOffer_3_Duplicate {

    /**
     * 解法一：
     *      1. 将数组中的元素进行排序
     *      2. 如果数组中的某个元素与其下一个元素相等，则返回true，并将该元素值赋给duplication[0]
     * */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        for(int i = 0; i < length - 1; i++) {
            if(numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 解法二：
     *      不对数组进行排序，不使用额外的数组空间，利用数组元素值和下标之间的关系进行求解
     * */
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0) {
            return false;
        }
        for(int i = 0; i < length; i++) {
            while(i != numbers[i]) {
                if(numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
