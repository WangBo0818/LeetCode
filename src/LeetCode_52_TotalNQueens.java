/**
 * @author wb
 * @date 2020/1/15 - 17:34
 * LeetCode---52. N 皇后II
 */
public class LeetCode_52_TotalNQueens {
    /**
     * 与 LeetCode---51. N 皇后的解法没有什么区别
     * */
    int count;

    public int totalNQueens(int n) {
        // 一行中皇后所处的列
        if(n == 1) {
            return 1;
        }
        int[] result = new int[n];
        calQueens(0, n, result);
        return count;
    }

    public void calQueens(int row, int n, int[] result) {
        // 当row == n时，循环结束，返回
        if(row == n) {
            count++;
            return ;
        }

        for(int colmun = 0; colmun < n; colmun++) {
            if(isLegal(row, colmun, result)) {
                //进入下一次递归
                result[row] = colmun;
                calQueens(row + 1, n, result);
            }
            // 回溯到下一列
        }
    }

    public boolean isLegal(int row, int colmun, int[] result) {
        // 判断与前面的每一行是否冲突
        for(int i = 0; i < row; i++) {
            // 同一列、主对角线、次对掉线是否冲突
            if(colmun == result[i] || i + result[i] == colmun + row || result[i] - i == colmun - row) {
                return false;
            }
        }
        return true;
    }
}
