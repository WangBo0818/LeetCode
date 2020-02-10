import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/2/10 - 22:13
 * LeetCode---77. 组合
 */
public class LeetCode_77_Combine {

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backTrack(res, tmp, n, k, 1);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> tmp, int n, int k, int index) {
        // 递归出口
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = index; i < n + 1; i++) {
            tmp.add(i);
            backTrack(res, tmp, n, k, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
