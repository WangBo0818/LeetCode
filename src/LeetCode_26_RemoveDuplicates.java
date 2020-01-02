/**
 * @author wb
 * @date 2020/1/2 - 9:38
 * LeetCode---26. 删除排序数组中的重复项
 */
public class LeetCode_26_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[count] != nums[j]) {
                count++;
                nums[count] = nums[j];
            }
        }
        return count + 1;
    }
}
