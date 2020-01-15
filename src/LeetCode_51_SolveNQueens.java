import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/1/15 - 16:55
 * LeetCode---51. N 皇后
 */
public class LeetCode_51_SolveNQueens {

    /**
     * 八皇后问题是一个以国际象棋为背景的问题：如何能够在8×8的国际象棋棋盘上放置八个皇后，
     * 使得任何一个皇后都无法直接吃掉其他的皇后？
     * 为了达到此目的，任两个皇后都不能处于同一条横行、纵行或斜线上。
     * 八皇后问题可以推广为更一般的n皇后摆放问题：这时棋盘的大小变为n×n，而皇后个数也变成n。
     * 当且仅当n = 1或n ≥ 4时问题有解
     * */
    private static List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        // 每一行中皇后所在的列
        int[] queens = new int[n];
        // 初始从第 0 行开始放置皇后的
        backTrack(queens, 0, n);
        return res;
    }

    private void backTrack(int[] queens, int row, int n) {
        // 递归出口：当 row == n，即已经到达第 n 行
        if (row == n) {
            // 得到解决方案
            getPrint(queens);
            return ;
        }
        // 未到达第 n 行，则找到皇后在该行所处列的位置
        for (int column = 0; column < n; column++) {
            // 判断该行列的位置是否满足放置皇后需求
            // 满足的条件是同一行、同一列、两条对角线上不能有其他的皇后
            if (isLegal(row, column, queens)) {
                queens[row] = column;
                backTrack(queens, row + 1, n);
            }
            // 不满足，继续判断下一列
        }
    }

    private boolean isLegal(int row, int column, int[] queens) {
        for (int i = 0; i < row; i++) {
            // 同一列、主对角线、次对角线上有其他的皇后，返回 false
            if (queens[i] == column || queens[i] + i == row + column || queens[i] - i == column - row) {
                return false;
            }
        }
        return true;
    }

    private void getPrint(int[] queens) {
        List<String > tmp = new ArrayList<>();
        for (int row = 0; row < queens.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int column = 0; column < queens.length; column++) {
                // 当 queens[row] == column 时，代表在该行，就 column 所在的位置是皇后
                if (column == queens[row]) {
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            tmp.add(sb.toString());
        }
        res.add(tmp);
    }
}
