
import java.util.*;

/**
 * @author wb
 * @date 2019/12/20 - 14:19
 * LeetCode47---全排列II
 */
public class LeetCode_47_PermuteUnique {

    public static void main(String[] args) {
        List<List<Integer>> res = permuteUnique2(new int[] {1, 1, 2});
        for(int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    /**
     * 解法一：
     * 在LeetCode46全排列的基础上，将返回结果中的重复元素去掉。该解法在LeetCode上只能通过10个测试用例，第11个测试用例超时,
     * 使用Set去重得当（我的解法是在回溯结束后，将output中的数据放入Set中去重；如果真的使用Set去重，推荐在回溯的过程中将结果放入Set）的话，
     *  可以通过，但是时间复杂度太差。
     * 因此使用Set去重的解法不推荐
     * */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> num_list = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTrack(output, num_list, nums, visited);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < output.size(); i++) {
            set.add(output.get(i));
        }
        output.removeAll(output);
        Iterator iterator =  set.iterator();
        while (iterator.hasNext()) {
            output.add((List<Integer>)iterator.next());
        }
        return output;
    }

    private static void backTrack(List<List<Integer>> output, List<Integer> tmp, int[] nums, int[] visited) {
        // 递归出口
        if(tmp.size() == nums.length) {
            output.add(new ArrayList<>(tmp));
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1) {
                // 该元素已经被访问过了，结束本次循环
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backTrack(output, tmp, nums, visited);
            // 递归结束回溯到上一步
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * 解法二：
     * 使用回溯 + 剪枝来去除重复的序列
     *      回溯的步骤和LeetCode46相同
     *      剪枝的步骤如下：
     *          1.将题目中的数组进行排序，用来判断是否需要剪枝
     *          2.当nums[i]与nums[i-1]相等时，并且visited[i]未被访问时，需要剪枝，即结束本次循环
     *  算法执行时间：1ms，内存消耗：39.8MB
     * */
    public static List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> num_list = new ArrayList<>();
        // 用来记录当前元素是否已经访问过
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        backTrack2(output, num_list, nums, visited);
        return output;
    }

    private static void backTrack2(List<List<Integer>> output, List<Integer> tmp, int[] nums, int[] visited) {
        // 递归出口
        if(tmp.size() == nums.length) {
            output.add(new ArrayList<>(tmp));
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1) {
                // 如果该元素已经被访问过，则跳出本次循环
                continue;
            }
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            // 置将访问状态设为已访问
            visited[i] = 1;
            tmp.add(nums[i]);
            backTrack2(output, tmp, nums, visited);
            // 递归结束后回溯到上一步
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
