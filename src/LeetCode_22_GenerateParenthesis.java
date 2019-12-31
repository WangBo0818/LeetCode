import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2019/12/31 - 8:52
 * LeetCode---22. 括号生成
 */
public class LeetCode_22_GenerateParenthesis {

    /**
     * 本题可以通过递归来生成所有序列。在生成序列的过程中需要判断序列是否是有效的。我们可以通过
     * 比较左括号'(' 减去有括号')' 的差值来进行判断。如果该差值始终小于0或者不以0结尾，该序列
     * 就是无效的，否则就是有效的。
     *
     * 对于上面的思路可以对其优化一下，只有在我们知道序列仍然保持有效时才添加'(' 或 ')'，
     * 而不是每次都添加。有效的条件是：先放左括号，而如果右括号的数量小于左括号的数量，则可以放
     * 右括号。
     * */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, "", 0, 0, n);
        return res;
    }

    private void backTrack(List<String> res, String tmp, int open, int close, int n) {
        // 递归出口
        if(tmp.length() == n * 2) {
            res.add(tmp);
            return ;
        }
        if(open < n) {
            backTrack(res, tmp+'(', open+1, close, n);
        }
        if(close < n) {
            backTrack(res, tmp+')', open, close+1, n);
        }
    }
}
