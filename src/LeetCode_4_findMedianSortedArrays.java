import java.util.Arrays;

/**
 * @author wb
 * @date 2019/12/25 - 12:36
 * LeetCode---4. 寻找两个有序数组的中位数
 */
public class LeetCode_4_findMedianSortedArrays {
    /**
     * 解法一：
     *  将两个有序数组合并成一个数组，然后对合并后的数组进行排序，最后找出中位数
     * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length+nums2.length];
        for(int i = 0; i < nums1.length; i++) {
            array[i] = nums1[i];
        }
        for(int i = nums1.length; i < array.length; i++) {
            array[i] = nums2[i-nums1.length];
        }
        Arrays.sort(array);
        if(array.length % 2 != 0) {
            return (double)array[(array.length-1)/2];
        }else {
            return (double)(array[array.length/2] + array[(array.length/2)-1])/2;
        }
    }
}
