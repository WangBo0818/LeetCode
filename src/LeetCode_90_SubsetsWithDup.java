import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/2/8 - 10:53
 * LeetCode---90. 子集II
 */
public class LeetCode_90_SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTrack(res, tmp, nums, visited, 0);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int[] visited, int index) {
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backTrack(res, tmp, nums, visited, i+1);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
