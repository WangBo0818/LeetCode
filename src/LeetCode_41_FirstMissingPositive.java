import java.util.Arrays;

/**
 * @author wb
 * @date 2020/1/13 - 11:11
 * LeetCode---41. 缺失的第一个正数
 */
public class LeetCode_41_FirstMissingPositive {

    /**
     * 思路很简单，也很好理解，一看代码就知道了，虽然不符合题目 O(n) 的要求
     * */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int target = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                target += 1;
            }
        }
        return target;
    }
}
