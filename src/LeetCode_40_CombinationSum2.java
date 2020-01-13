import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wb
 * @date 2020/1/13 - 10:11
 * LeetCode---40. 组数总和II
 */
public class LeetCode_40_CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] visited = new int[candidates.length];
        backTrack(res, tmp, candidates, visited, target, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int[] visited, int target, int index) {
        // 递归出口
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return ;
        }
        if (target < 0) {
            return ;
        }
        for (int start = index; start < candidates.length; start++) {
            if (visited[start] == 1) {
                continue ;
            }
            if (start >= 1 && candidates[start] == candidates[start - 1] && visited[start-1] == 0) {
                continue ;
            }
            visited[start] = 1;
            tmp.add(candidates[start]);
            backTrack(res, tmp, candidates, visited, target-candidates[start], start);
            visited[start] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
