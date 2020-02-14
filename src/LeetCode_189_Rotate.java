/**
 * @author wb
 * @date 2020/2/14 - 19:57
 * LeetCode---189. 旋转数组
 */
public class LeetCode_189_Rotate {

    /**
     * 解题思路：
     *  先将整个数组反转，然后反转数组前 k % nums.length 个元素，接着反转剩下的元素
     * */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
