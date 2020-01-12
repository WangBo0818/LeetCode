/**
 * @author wb
 * @date 2020/1/12 - 9:09
 * LeetCode---35. 搜索插入位置
 */
public class LeetCode_35_SearchInsert {
    /**
     * 二分查找
     * */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target) {
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
