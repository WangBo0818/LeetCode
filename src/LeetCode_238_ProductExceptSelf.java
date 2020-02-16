/**
 * @author wb
 * @date 2020/2/16 - 10:32
 * LeetCode---238. 除自身以外数组的乘积
 */
public class LeetCode_238_ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int tmp = 1;
        // 计算自身左边的元素乘积
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        // 计算自身右边的元素乘积
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = tmp;
            // 左边元素与右边元素的乘积即为最终结果
            tmp *= nums[i];
        }
        return res;
    }
}
