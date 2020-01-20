/**
 * @author wb
 * @date 2020/1/20 - 18:47
 * LeetCode---59. 螺旋矩阵II
 */
public class LeetCode_59_GenerateMatrix {

    /**
     * 和 54 题螺旋矩阵本质相同
     * */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1;
        int up = 0, down = n - 1;
        int num = 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                res[up][i] = num;
                num++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                res[i][right] = num;
                num++;
            }
            right--;
            for (int i = right; i >= left && up <= down; i--) {
                res[down][i] = num;
                num++;
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                res[i][left] = num;
                num++;
            }
            left++;
        }
        return res;
    }
}
