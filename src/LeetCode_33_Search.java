import java.util.Arrays;

/**
 * @author wb
 * @date 2020/1/12 - 8:14
 * LeetCode---33. 搜索旋转排序数组
 */
public class LeetCode_33_Search {

    /**
     * 要求算法的时间复杂度为 O(log n)，所以使用二分查找.
     * */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < nums[right]) {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
