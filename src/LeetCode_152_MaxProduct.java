/**
 * @author wb
 * @date 2020/2/9 - 20:42
 * LeetCode---152. 乘积最大子序列
 */
public class LeetCode_152_MaxProduct {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = currentMax;
                currentMax = currentMin;
                currentMin = tmp;
            }
            currentMax = Math.max(nums[i], nums[i] * currentMax);
            currentMin = Math.min(nums[i], nums[i] * currentMin);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
