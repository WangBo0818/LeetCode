/**
 * @author wb
 * @date 2020/2/16 - 17:12
 * 剑指 Offer---13. 机器人的运动范围
 */
public class SwordMeansOffer_13_MovingCount {

    private int count = 0;
    private int rows;
    private int cols;
    private int threshold;

    public int movingCount(int threshold, int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return 0;
        }
        this.rows = rows;
        this.cols = cols;
        // 初始化二维数组
        int[][] digitSum = buildDigitSum();
        return 0;
    }

    private int[][] buildDigitSum() {
        int[][] digitSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                digitSum[i][j] = calSum(i, j);
            }
        }
        return null;
    }

    private static int calSum(int row, int col) {
        int res = 0;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(calSum(35, 37));
    }
}
