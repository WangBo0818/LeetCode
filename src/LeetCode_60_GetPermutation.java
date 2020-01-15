
import java.util.LinkedList;
import java.util.List;

/**
 * @author wb
 * @date 2019/12/20 - 16:21
 * LeetCode---60：第k个排列
 */
public class LeetCode_60_GetPermutation {

    public static void main(String[] args) {
        System.out.println(getPermutation(8, 13801));
    }

    private static List<StringBuilder> res = new LinkedList<>();

    /**
     * 这题使用回溯算法的思路简单，但是时间复杂度和空间复杂度都太差
     * 大多数人都是利用数学方法求解
     * */
    public static String getPermutation(int n, int k) {
        int[] visited = new int[n];
        backTrack(n, k, 0, visited, new StringBuilder(""));
        return res.get(k - 1).toString();
    }

    private static void backTrack(int n, int k, int count, int[] visited, StringBuilder s) {
        // 递归出口
        if (count == n) {
            res.add(new StringBuilder(s));
            return;
        }
        if (res.size() == k) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            s.append((i + 1));
            backTrack(n, k, count + 1, visited, s);
            visited[i] = 0;
            s.delete(s.length() - 1, s.length());
        }
    }
}
