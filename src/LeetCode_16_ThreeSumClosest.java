import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wb
 * @date 2019/12/28 - 12:06
 * LeetCode---16. 最接近的三数之和
 */
public class LeetCode_16_ThreeSumClosest {
    /**
     * 解法：
     *  和LeetCode15题解法差不多，使用排序 + 双指针
     * */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 0;
        int tmp = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if(threeSum > target) {
                    if(tmp > threeSum - target) {
                        tmp = threeSum - target;
                        closestSum = threeSum;
                    }
                    right--;
                }else if(threeSum < target) {
                    if(tmp > target - threeSum) {
                        tmp = target - threeSum;
                        closestSum =threeSum;
                    }
                    left++;
                }else {
                    return target;
                }
            }
        }
        return closestSum;
    }
}
