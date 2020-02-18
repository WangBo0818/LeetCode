import java.util.ArrayList;

/**
 * @author wb
 * @date 2020/2/18 - 0:41
 * 剑指 Offer---28. 顺时针打印矩阵
 */
public class SwordMeansOffer_28_PrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix.length == 0 || matrix == null || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && up <= down; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
