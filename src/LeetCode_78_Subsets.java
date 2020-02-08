import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/2/8 - 10:27
 * LeetCode---78. 子集
 */
public class LeetCode_78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backTrack(res, tmp, nums, 0);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index) {
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTrack(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
