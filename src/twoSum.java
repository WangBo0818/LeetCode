/**
 * @author wb
 * @date 2019/12/25 - 10:16
 * LeetCode---1. 两数之和
 */
public class twoSum {
    /**
     * 解法：暴力破解法
     *        因为是求两数之和，令num = target - nums[i]，然后遍历nums数组，找到nums[j] = num，
     *        此时返回i,j即可
     * */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            // 题目要求不能重复使用这个数组中同样的元素，所以j = i + 1
            for(int j = i + 1; j < nums.length; j++) {
                if(num == nums[j]) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
