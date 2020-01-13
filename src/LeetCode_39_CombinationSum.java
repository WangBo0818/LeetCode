import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wb
 * @date 2020/1/13 - 9:43
 * LeetCode---39. 组数总和
 */
public class LeetCode_39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backTrack(res, tmp, candidates, target, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int index) {
        // 递归出口
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return ;
        }
        if (target < 0) {
            return ;
        }
        for (int start = index; start < candidates.length; start++) {
            tmp.add(candidates[start]);
            backTrack(res, tmp, candidates, target-candidates[start], start);
            tmp.remove(tmp.size() - 1);
        }
    }
}
