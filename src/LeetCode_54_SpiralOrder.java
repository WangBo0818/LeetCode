import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/1/18 - 21:41
 * LeetCode---54. 螺旋矩阵
 */
public class LeetCode_54_SpiralOrder {

    /**
     * 要注意边界的判断
     * */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
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
