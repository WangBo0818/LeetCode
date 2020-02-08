import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/2/8 - 11:18
 * LeetCode---118. 杨辉三角
 */
public class LeetCode_118_Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(new ArrayList<>());
        // 第一行一定是 1
        res.get(0).add(1);
        if (numRows == 1) {
            return res;
        }
        res.add(new ArrayList<>());
        // 第二行一定是 1 1
        res.get(1).add(1);
        res.get(1).add(1);
        for (int i = 2; i < numRows; i++) {
            // 每一行的第一个元素一定是 1
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                tmp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}
