/**
 * @author wb
 * @date 2020/2/12 - 22:11
 * LeetCode---162. 寻找峰值
 */
public class LeetCode_162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        // 先判断数组边界
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        for (int i = 1; i <= nums.length - 2; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
