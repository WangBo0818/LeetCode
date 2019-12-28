import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wb
 * @date 2019/12/28 - 10:38
 * LeetCode---15. 三数之和
 */
public class LeetCode_15_ThreeSum {
    /**
     * 解法一：排序 + 双指针
     *      首先将数组排序，然后用二分查找找出和为0的三个数
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 1; i++) {
            // 去除重复的三元组
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    left++;
                    right--;
                    // 去除重复的三元组
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // 去除重复的三元组
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
