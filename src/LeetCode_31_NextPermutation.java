import java.util.Arrays;

/**
 * @author wb
 * @date 2020/1/11 - 12:45
 * LeetCode---31. 下一个排列
 */
public class LeetCode_31_NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[] {
                1, 3, 2
        };
        nextPermutation(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * LeetCode 官网题解有一个动态图，看到后就会一目了然
     * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/
     * */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i >= 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换数组中 i, j 元素的位置
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
