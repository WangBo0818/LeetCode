/**
 * @author wb
 * @date 2020/1/17 - 11:07
 * LeetCode---48. 旋转头像
 */
public class LeetCode_48_Rotate {

    /**
     * 先转置矩阵，然后反转每一行
     *
     * 1 2 3         1 4 7         7 4 1
     * 4 5 6  ---->  2 5 8  ---->  8 5 2
     * 7 8 9         3 6 9         9 6 3
     * */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}
