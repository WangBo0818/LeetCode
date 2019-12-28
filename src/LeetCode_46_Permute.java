import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wb
 * @date 2019/12/20 - 13:21
 * leetcode46---全排列
 */
public class LeetCode_46_Permute {

    public static void main(String[] args) {
        List<List<Integer>> res = permute2(new int[] {1, 2, 3});
        for(int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    /**
     * 解法一：
     * 该解法是LeetCode上的官方题解，执行用时：1ms，内存消耗：38MB，
     *      解法的时间复杂度和空间复杂度都很好，但是刚开始看的时候不是很理解
     *          例如：为什么下面的递归会包含所有的解？
     *                为什么下面的递归的交换的结果不会重复？
     *      所以我自己根据自己的思路实现了解法二
     * */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> num_list = new ArrayList<>();
        for (int num : nums) {
            num_list.add(num);
        }
        backtrack(nums.length, num_list, output, 0);
        return output;
    }

    private static void backtrack(int n, List<Integer> num_list, List<List<Integer>> output, int first) {
        // 递归出口
        if(first == n) {
            output.add(new ArrayList<>(num_list));
        }

        for(int i = first; i < n; i++) {
            Collections.swap(num_list, first, i);
            backtrack(n, num_list, output, first + 1);
            Collections.swap(num_list, first, i);
        }
    }

    /**
     * 解法二：
     * 该解法显示的定义一个visited数组用来标识是否访问，思路简单明了，执行用时：1ms，内存消耗：36.5MB
     * */
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> num_list = new ArrayList<>();
        // 用来记录当前元素是否已经访问过
        int[] visited = new int[nums.length];
        backTrack(output, num_list, nums, visited);
        return output;
    }

    private static void backTrack(List<List<Integer>> output, List<Integer> tmp, int[] nums, int[] visited) {
        // 递归出口
        if(tmp.size() == nums.length) {
            output.add(new ArrayList<>(tmp));
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1) {
                // 如果该元素已经被访问过，则跳出本次循环
                continue;
            }
            // 将访问状态设置为已访问
            visited[i] = 1;
            tmp.add(nums[i]);
            backTrack(output, tmp, nums, visited);
            // 递归结束后回溯到上一步
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
