import java.util.Arrays;

/**
 * @author wb
 * @date 2020/4/1 - 12:53
 * LeetCode---213. 打家劫舍II
 */
public class LeetCode_213_Rob {

    public int rob(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        // 偷第一个，不偷最后一个房间
        // 偷最后一个，不偷第一个房间
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int myRob(int[] nums) {
        int pre = 0, cur = 0;
        for (int num : nums) {
            int tmp = cur;
            cur = Math.max(cur, pre + num);
            pre = tmp;
        }
        return cur;
    }
}
