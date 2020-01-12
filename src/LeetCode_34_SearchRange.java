/**
 * @author wb
 * @date 2020/1/12 - 9:03
 * LeetCode---34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode_34_SearchRange {
    /**
     * 题目要求的时间复杂度为 O(log n，所以使用二分查找。
     *  使用二分查找找到指定元素值后，要判断该元素值前、后是否有与之相等的元素
     * */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] arr = new int[2];
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                for(int i = mid; i >= 0; i--) {
                    if(nums[i] == target) {
                        arr[0] = i;
                    }
                }
                for(int i = mid; i < nums.length; i++) {
                    if(nums[i] == target) {
                        arr[1] = i;
                    }
                }
                return arr;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        arr[0] = -1;
        arr[1] = -1;
        return arr;
    }
}
